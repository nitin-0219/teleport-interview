package com.smartload.optimizer.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public class OptimizeRequest {

    @NotNull @Valid
    private Truck truck;
    @NotEmpty @Valid
    private List<Order> orders;

    public Truck getTruck() { return truck; }
    public void setTruck(Truck truck) { this.truck = truck; }
    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
}
