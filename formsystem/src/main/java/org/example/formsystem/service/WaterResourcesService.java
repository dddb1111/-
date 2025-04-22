package org.example.formsystem.service;

import org.example.formsystem.entity.WaterResources;
import org.example.formsystem.utils.Result;

import java.util.List;

public interface WaterResourcesService {
    Result<List<WaterResources>> getAllWaterResources();
    Result<WaterResources> getWaterResourcesById(Integer id);
    Result<?> createWaterResources(WaterResources waterResources);
    Result<?> updateWaterResources(Integer id, WaterResources waterResources);
    Result<?> deleteWaterResources(Integer id);
}