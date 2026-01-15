package com.smartload.optimizer.optimizer;

import com.smartload.optimizer.model.Order;
import com.smartload.optimizer.model.OptimizationResult;

import java.util.ArrayList;
import java.util.List;

public class BitmaskOptimizer {

    public static OptimizationResult solve(List<Order> orders, long maxW, long maxV) {
        int n = orders.size();
        long bestPayout = 0;
        int bestMask = 0;

        long[] w = new long[n];
        long[] v = new long[n];
        long[] p = new long[n];

        for (int i = 0; i < n; i++) {
            w[i] = orders.get(i).getWeightLbs();
            v[i] = orders.get(i).getVolumeCuft();
            p[i] = orders.get(i).getPayoutCents();
        }

        for (int mask = 1; mask < (1 << n); mask++) {
            long tw = 0, tv = 0, tp = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    tw += w[i];
                    if (tw > maxW) break;
                    tv += v[i];
                    if (tv > maxV) break;
                    tp += p[i];
                }
            }

            if (tw <= maxW && tv <= maxV && tp > bestPayout) {
                bestPayout = tp;
                bestMask = mask;
            }
        }

        List<String> ids = new ArrayList<>();
        long fw = 0, fv = 0;

        for (int i = 0; i < n; i++) {
            if ((bestMask & (1 << i)) != 0) {
                ids.add(orders.get(i).getId());
                fw += w[i];
                fv += v[i];
            }
        }

        return new OptimizationResult(ids, bestPayout, fw, fv);
    }
}
