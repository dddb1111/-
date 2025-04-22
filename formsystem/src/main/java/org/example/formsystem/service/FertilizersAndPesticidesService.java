package org.example.formsystem.service;

import org.example.formsystem.entity.FertilizersAndPesticides;
import org.example.formsystem.utils.Result;

import java.util.List;

public interface FertilizersAndPesticidesService {
    Result<List<FertilizersAndPesticides>> getAllFertilizersAndPesticides();
    Result<FertilizersAndPesticides> getFertilizersAndPesticidesById(Integer id);
    Result<?> createFertilizersAndPesticides(FertilizersAndPesticides fertilizersAndPesticides);
    Result<?> updateFertilizersAndPesticides(Integer id, FertilizersAndPesticides fertilizersAndPesticides);
    Result<?> deleteFertilizersAndPesticides(Integer id);
}
