package org.example.formsystem.controller;

import org.example.formsystem.entity.WaterResources;
import org.example.formsystem.service.WaterResourcesService;
import org.example.formsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/water-resources")
public class WaterResourcesController {
    @Autowired
    private WaterResourcesService waterResourcesService;

    @GetMapping
    public Result<List<WaterResources>> getAllWaterResources() {
        return waterResourcesService.getAllWaterResources();
    }

    @GetMapping("/{id}")
    public Result<WaterResources> getWaterResourcesById(@PathVariable("id") Integer id) {
        return waterResourcesService.getWaterResourcesById(id);
    }

    @PostMapping
    public Result<?> createWaterResources(@RequestBody WaterResources waterResources) {
        return waterResourcesService.createWaterResources(waterResources);
    }

    @PutMapping("/{id}")
    public Result<?> updateWaterResources(@PathVariable("id") Integer id, @RequestBody WaterResources waterResources) {
        return waterResourcesService.updateWaterResources(id, waterResources);
    }

    @DeleteMapping("/{id}")
    public Result<?> deleteWaterResources(@PathVariable("id") Integer id) {
        return waterResourcesService.deleteWaterResources(id);
    }
}
