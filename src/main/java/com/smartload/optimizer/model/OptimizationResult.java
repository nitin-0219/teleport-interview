package com.smartload.optimizer.model;

import java.util.List;

public record OptimizationResult(List<String> ids, long payout, long weight, long volume) {}
