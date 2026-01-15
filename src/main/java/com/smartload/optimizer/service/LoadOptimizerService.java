package com.smartload.optimizer.service;

import com.smartload.optimizer.model.*;
import com.smartload.optimizer.optimizer.BitmaskOptimizer;
import com.smartload.optimizer.exception.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@Service
public class LoadOptimizerService {

    @Cacheable(value = "optimizationResults",
              key = "{#req.truck, #req.orders}",
              unless = "#result == null")
    public OptimizeResponse optimize(OptimizeRequest req) {
        validateRequest(req);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            Truck truck = req.getTruck();
            List<Order> orders = req.getOrders();

            OptimizationResult result = BitmaskOptimizer.solve(
                    orders,
                    truck.getMaxWeightLbs(),
                    truck.getMaxVolumeCuft()
            );

            OptimizeResponse response = buildResponse(truck, result);

            stopWatch.stop();
            System.out.println("Optimization completed in"+ stopWatch.getTotalTimeMillis()+"ms");

            return response;
        } catch (Exception e) {
            throw new OptimizationException("Failed to optimize load: " + e.getMessage(), e);
        }
    }

    private void validateRequest(OptimizeRequest req) {
        if (req == null) {
            throw new ValidationException("Request cannot be null");
        }
        if (req.getTruck() == null || req.getOrders() == null) {
            throw new ValidationException("Truck and orders are required");
        }
    }

    private OptimizeResponse buildResponse(Truck truck, OptimizationResult result) {
        return OptimizeResponse.builder()
                .truckId(truck.getId())
                .selectedOrderIds(result.ids())
                .totalPayoutCents(validateAndGet(result.payout(), "payout"))
                .totalWeightLbs(validateAndGet(result.weight(), "weight"))
                .totalVolumeCuft(validateAndGet(result.volume(), "volume"))
                .utilizationWeightPercent(calculateUtilization(result.weight(), truck.getMaxWeightLbs()))
                .utilizationVolumePercent(calculateUtilization(result.volume(), truck.getMaxVolumeCuft()))
                .build();
    }

    private double calculateUtilization(long used, long max) {
        if (max <= 0) {
            throw new IllegalStateException("Max capacity must be greater than zero");
        }
        return BigDecimal.valueOf(used * 100.0 / max)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private <T> T validateAndGet(T value, String fieldName) {
        if (value == null) {
            throw new IllegalStateException(fieldName + " cannot be null in optimization result");
        }
        return value;
    }

}

