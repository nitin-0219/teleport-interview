package com.smartload.optimizer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class Order {
    private String id;
    
    @JsonProperty("payout_cents")
    private int payoutCents;
    
    @JsonProperty("weight_lbs")
    private int weightLbs;
    
    @JsonProperty("volume_cuft")
    private int volumeCuft;
    
    private String origin;
    private String destination;
    
    @JsonProperty("pickup_date")
    private String pickupDate;
    
    @JsonProperty("delivery_date")
    private String deliveryDate;
    
    @JsonProperty("is_hazmat")
    private boolean isHazmat;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getPayoutCents() { return payoutCents; }
    public void setPayoutCents(int payoutCents) { this.payoutCents = payoutCents; }
    public int getWeightLbs() { return weightLbs; }
    public void setWeightLbs(int weightLbs) { this.weightLbs = weightLbs; }
    public int getVolumeCuft() { return volumeCuft; }
    public void setVolumeCuft(int volumeCuft) { this.volumeCuft = volumeCuft; }
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getPickupDate() { return pickupDate; }
    public void setPickupDate(String pickupDate) { this.pickupDate = pickupDate; }
    public String getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(String deliveryDate) { this.deliveryDate = deliveryDate; }
    public boolean isHazmat() { return isHazmat; }
    public void setHazmat(boolean hazmat) { isHazmat = hazmat; }
}