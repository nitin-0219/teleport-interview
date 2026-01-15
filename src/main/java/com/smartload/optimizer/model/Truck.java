package com.smartload.optimizer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Truck {
        
    private String id;
    
    @JsonProperty("max_weight_lbs")
    private int maxWeightLbs;
    
    @JsonProperty("max_volume_cuft")
    private int maxVolumeCuft;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getMaxWeightLbs() { return maxWeightLbs; }
    public void setMaxWeightLbs(int maxWeightLbs) { this.maxWeightLbs = maxWeightLbs; }
    public int getMaxVolumeCuft() { return maxVolumeCuft; }
    public void setMaxVolumeCuft(int maxVolumeCuft) { this.maxVolumeCuft = maxVolumeCuft; }
}