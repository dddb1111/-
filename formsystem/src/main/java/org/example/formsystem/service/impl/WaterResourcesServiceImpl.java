package org.example.formsystem.service.impl;

import org.example.formsystem.entity.WaterResources;
import org.example.formsystem.mapper.WaterResourcesMapper;
import org.example.formsystem.service.WaterResourcesService;
import org.example.formsystem.utils.Result;
import org.example.formsystem.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterResourcesServiceImpl implements WaterResourcesService {
    @Autowired
    private WaterResourcesMapper waterResourcesMapper;

    @Override
    public Result<List<WaterResources>> getAllWaterResources() {
        List<WaterResources> waterResourcesList = waterResourcesMapper.selectAll();
        return Result.success(waterResourcesList);
    }

    @Override
    public Result<WaterResources> getWaterResourcesById(Integer id) {
        if (id == null || id <= 0) {
            return Result.fail(ResultCode.PARAM_ERROR, "水源管理 ID 必须为正整数");
        }
        WaterResources waterResources = waterResourcesMapper.selectById(id);
        if (waterResources == null) {
            return Result.fail(ResultCode.RESOURCE_NOT_FOUND, "水源管理记录不存在");
        }
        return Result.success(waterResources);
    }

    @Override
    public Result<?> createWaterResources(WaterResources waterResources) {
        if (waterResources.getFarmId() == null || waterResources.getFarmId() <= 0) {
            return Result.fail(ResultCode.PARAM_ERROR, "农场 ID 必须为正整数");
        }
        int count = waterResourcesMapper.insert(waterResources);
        return count > 0 ? Result.success() : Result.fail(ResultCode.FAIL, "创建水源管理记录失败");
    }

    @Override
    public Result<?> updateWaterResources(Integer id, WaterResources waterResources) {
        if (id == null || id <= 0) {
            return Result.fail(ResultCode.PARAM_ERROR, "水源管理 ID 必须为正整数");
        }
        WaterResources existingWaterResources = waterResourcesMapper.selectById(id);
        if (existingWaterResources == null) {
            return Result.fail(ResultCode.RESOURCE_NOT_FOUND, "水源管理记录不存在");
        }
        waterResources.setId(id);
        int count = waterResourcesMapper.update(waterResources);
        return count > 0 ? Result.success() : Result.fail(ResultCode.FAIL, "更新水源管理记录失败");
    }

    @Override
    public Result<?> deleteWaterResources(Integer id) {
        if (id == null || id <= 0) {
            return Result.fail(ResultCode.PARAM_ERROR, "水源管理 ID 必须为正整数");
        }
        WaterResources existingWaterResources = waterResourcesMapper.selectById(id);
        if (existingWaterResources == null) {
            return Result.fail(ResultCode.RESOURCE_NOT_FOUND, "水源管理记录不存在");
        }
        int count = waterResourcesMapper.deleteById(id);
        return count > 0 ? Result.success() : Result.fail(ResultCode.FAIL, "删除水源管理记录失败");
    }
}
