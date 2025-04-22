package org.example.formsystem.controller;

import org.example.formsystem.entity.FertilizersAndPesticides;
import org.example.formsystem.service.FertilizersAndPesticidesService;
import org.example.formsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fertilizers-and-pesticides")
public class FertilizersAndPesticidesController {
    @Autowired
    private FertilizersAndPesticidesService fertilizersAndPesticidesService;

    @GetMapping
    public Result<List<FertilizersAndPesticides>> getAllFertilizersAndPesticides() {
        return fertilizersAndPesticidesService.getAllFertilizersAndPesticides();
    }

    @GetMapping("/{id}")
    public Result<FertilizersAndPesticides> getFertilizersAndPesticidesById(@PathVariable("id") Integer id) {
        return fertilizersAndPesticidesService.getFertilizersAndPesticidesById(id);
    }

    @PostMapping
    public Result<?> createFertilizersAndPesticides(@RequestBody FertilizersAndPesticides fertilizersAndPesticides) {
        return fertilizersAndPesticidesService.createFertilizersAndPesticides(fertilizersAndPesticides);
    }

    @PutMapping("/{id}")
    public Result<?> updateFertilizersAndPesticides(@PathVariable("id") Integer id, @RequestBody FertilizersAndPesticides fertilizersAndPesticides) {
        return fertilizersAndPesticidesService.updateFertilizersAndPesticides(id, fertilizersAndPesticides);
    }

    @DeleteMapping("/{id}")
    public Result<?> deleteFertilizersAndPesticides(@PathVariable("id") Integer id) {
        return fertilizersAndPesticidesService.deleteFertilizersAndPesticides(id);
    }
}
