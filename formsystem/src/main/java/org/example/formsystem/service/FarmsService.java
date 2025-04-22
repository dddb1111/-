package org.example.formsystem.service;

import org.example.formsystem.entity.Farms;
import org.example.formsystem.utils.Result;

import java.util.List;

public interface FarmsService {
    Result<List<Farms>> getAllFarms();
    Result<Farms> getFarmById(Integer id);
    Result<?> createFarm(Farms farms);
    Result<?> updateFarm(Integer id, Farms farms);
    Result<?> deleteFarm(Integer id);
}