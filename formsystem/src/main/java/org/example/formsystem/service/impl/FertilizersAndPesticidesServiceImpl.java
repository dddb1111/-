package org.example.formsystem.service.impl;

import org.example.formsystem.entity.FertilizersAndPesticides;
import org.example.formsystem.mapper.FertilizersAndPesticidesMapper;
import org.example.formsystem.service.FertilizersAndPesticidesService;
import org.example.formsystem.utils.Result;
import org.example.formsystem.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FertilizersAndPesticidesServiceImpl implements FertilizersAndPesticidesService {
    @Autowired
    private FertilizersAndPesticidesMapper fertilizersAndPesticidesMapper;

    @Override
    public Result<List<FertilizersAndPesticides>> getAllFertilizersAndPesticides() {
        List<FertilizersAndPesticides> fertilizersAndPesticidesList = fertilizersAndPesticidesMapper.selectAll();
        return Result.success(fertilizersAndPesticidesList);
    }

    @Override
    public Result<FertilizersAndPesticides> getFertilizersAndPesticidesById(Integer id) {
        if (id == null || id <= 0) {
            return Result.fail(ResultCode.PARAM_ERROR, "肥料和农药记录 ID 必须为正整数");
        }
        FertilizersAndPesticides fertilizersAndPesticides = fertilizersAndPesticidesMapper.selectById(id);
        if (fertilizersAndPesticides == null) {
            return Result.fail(ResultCode.RESOURCE_NOT_FOUND, "肥料和农药记录不存在");
        }
        return Result.success(fertilizersAndPesticides);
    }

    @Override
    public Result<?> createFertilizersAndPesticides(FertilizersAndPesticides fertilizersAndPesticides) {
        if (fertilizersAndPesticides.getFarmId() == null || fertilizersAndPesticides.getFarmId() <= 0) {
            return Result.fail(ResultCode.PARAM_ERROR, "农场 ID 必须为正整数");
        }
        int count = fertilizersAndPesticidesMapper.insert(fertilizersAndPesticides);
        return count > 0 ? Result.success() : Result.fail(ResultCode.FAIL, "创建肥料和农药记录失败");
    }

    @Override
    public Result<?> updateFertilizersAndPesticides(Integer id, FertilizersAndPesticides fertilizersAndPesticides) {
        if (id == null || id <= 0) {
            return Result.fail(ResultCode.PARAM_ERROR, "肥料和农药记录 ID 必须为正整数");
        }
        FertilizersAndPesticides existingFertilizersAndPesticides = fertilizersAndPesticidesMapper.selectById(id);
        if (existingFertilizersAndPesticides == null) {
            return Result.fail(ResultCode.RESOURCE_NOT_FOUND, "肥料和农药记录不存在");
        }
        fertilizersAndPesticides.setId(id);
        int count = fertilizersAndPesticidesMapper.update(fertilizersAndPesticides);
        return count > 0 ? Result.success() : Result.fail(ResultCode.FAIL, "更新肥料和农药记录失败");
    }

    @Override
    public Result<?> deleteFertilizersAndPesticides(Integer id) {
        if (id == null || id <= 0) {
            return Result.fail(ResultCode.PARAM_ERROR, "肥料和农药记录 ID 必须为正整数");
        }
        FertilizersAndPesticides existingFertilizersAndPesticides = fertilizersAndPesticidesMapper.selectById(id);
        if (existingFertilizersAndPesticides == null) {
            return Result.fail(ResultCode.RESOURCE_NOT_FOUND, "肥料和农药记录不存在");
        }
        int count = fertilizersAndPesticidesMapper.deleteById(id);
        return count > 0 ? Result.success() : Result.fail(ResultCode.FAIL, "删除肥料和农药记录失败");
    }
}
