package org.example.formsystem.controller;

import org.example.formsystem.entity.Farms;
import org.example.formsystem.service.FarmsService;
import org.example.formsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmsController {
    @Autowired
    private FarmsService farmsService;

    @GetMapping
    public Result<List<Farms>> getAllFarms() {
        return farmsService.getAllFarms();
    }

    @GetMapping("/{id}")
    public Result<Farms> getFarmById(@PathVariable("id") Integer id) {
        return farmsService.getFarmById(id);
    }

    @PostMapping
    public Result<?> createFarm(@RequestBody Farms farms) {
        return farmsService.createFarm(farms);
    }

    @PutMapping("/{id}")
    public Result<?> updateFarm(@PathVariable("id") Integer id, @RequestBody Farms farms) {
        return farmsService.updateFarm(id, farms);
    }

    @DeleteMapping("/{id}")
    public Result<?> deleteFarm(@PathVariable("id") Integer id) {
        return farmsService.deleteFarm(id);
    }
}