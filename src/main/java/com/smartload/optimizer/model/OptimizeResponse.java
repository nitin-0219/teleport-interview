package com.smartload.optimizer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OptimizeResponse {
    @JsonProperty("truck_id")
    private String truckId;
    
    @JsonProperty("selected_order_ids")
    private List<String> selectedOrderIds;
    
    @JsonProperty("total_payout_cents")
    private long totalPayoutCents;
    
    @JsonProperty("total_weight_lbs")
    private long totalWeightLbs;
    
    @JsonProperty("total_volume_cuft")
    private long totalVolumeCuft;
    
    @JsonProperty("utilization_weight_percent")
    private double utilizationWeightPercent;
    
    @JsonProperty("utilization_volume_percent")
    private double utilizationVolumePercent;

    // Add getters for all fields
    public String getTruckId() { return truckId; }
    public List<String> getSelectedOrderIds() { return selectedOrderIds; }
    public long getTotalPayoutCents() { return totalPayoutCents; }
    public long getTotalWeightLbs() { return totalWeightLbs; }
    public long getTotalVolumeCuft() { return totalVolumeCuft; }
    public double getUtilizationWeightPercent() { return utilizationWeightPercent; }
    public double getUtilizationVolumePercent() { return utilizationVolumePercent; }

    // Keep the builder pattern
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final OptimizeResponse r = new OptimizeResponse();
        
        public Builder truckId(String v) { r.truckId = v; return this; }
        public Builder selectedOrderIds(List<String> v) { r.selectedOrderIds = v; return this; }
        public Builder totalPayoutCents(long v) { r.totalPayoutCents = v; return this; }
        public Builder totalWeightLbs(long v) { r.totalWeightLbs = v; return this; }
        public Builder totalVolumeCuft(long v) { r.totalVolumeCuft = v; return this; }
        public Builder utilizationWeightPercent(double v) { r.utilizationWeightPercent = v; return this; }
        public Builder utilizationVolumePercent(double v) { r.utilizationVolumePercent = v; return this; }
        public OptimizeResponse build() { return r; }
    }
}