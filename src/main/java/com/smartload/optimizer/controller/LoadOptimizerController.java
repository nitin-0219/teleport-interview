package com.smartload.optimizer.controller;

import com.smartload.optimizer.model.*;
import com.smartload.optimizer.service.LoadOptimizerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/load-optimizer")
public class LoadOptimizerController {

    private final LoadOptimizerService service;

    public LoadOptimizerController(LoadOptimizerService service) {
        this.service = service;
    }
    @PostMapping(
            value = "/optimize",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<OptimizeResponse> optimize(@RequestBody OptimizeRequest request) {
        return ResponseEntity.ok(service.optimize(request));
    }
}
