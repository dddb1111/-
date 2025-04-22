package org.example.formsystem.service.impl;

import io.micrometer.common.util.StringUtils;
import org.example.formsystem.entity.Farms;
import org.example.formsystem.mapper.FarmsMapper;
import org.example.formsystem.service.FarmsService;
import org.example.formsystem.utils.Result;
import org.example.formsystem.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmsServiceImpl implements FarmsService {
    @Autowired
    private FarmsMapper farmsMapper;

    @Override
    public Result<List<Farms>> getAllFarms() {
        List<Farms> farmsList = farmsMapper.selectAll();
        return Result.success(farmsList);
    }

    @Override
    public Result<Farms> getFarmById(Integer id) {
        if (id == null || id <= 0) {
            return Result.fail(ResultCode.PARAM_ERROR, "农场 ID 必须为正整数");
        }
        Farms farms = farmsMapper.selectById(id);
        if (farms == null) {
            return Result.fail(ResultCode.RESOURCE_NOT_FOUND, "农场不存在");
        }
        return Result.success(farms);
    }

    @Override
    public Result<?> createFarm(Farms farms) {
        if (StringUtils.isBlank(farms.getFarmName())) {
            return Result.fail(ResultCode.PARAM_ERROR, "农场名称不能为空");
        }
        int count = farmsMapper.insert(farms);
        return count > 0 ? Result.success() : Result.fail(ResultCode.FAIL, "创建农场失败");
    }

    @Override
    public Result<?> updateFarm(Integer id, Farms farms) {
        if (id == null || id <= 0) {
            return Result.fail(ResultCode.PARAM_ERROR, "农场 ID 必须为正整数");
        }
        Farms existingFarm = farmsMapper.selectById(id);
        if (existingFarm == null) {
            return Result.fail(ResultCode.RESOURCE_NOT_FOUND, "农场不存在");
        }
        farms.setId(id);
        int count = farmsMapper.update(farms);
        return count > 0 ? Result.success() : Result.fail(ResultCode.FAIL, "更新农场失败");
    }

    @Override
    public Result<?> deleteFarm(Integer id) {
        if (id == null || id <= 0) {
            return Result.fail(ResultCode.PARAM_ERROR, "农场 ID 必须为正整数");
        }
        Farms existingFarm = farmsMapper.selectById(id);
        if (existingFarm == null) {
            return Result.fail(ResultCode.RESOURCE_NOT_FOUND, "农场不存在");
        }
        int count = farmsMapper.deleteById(id);
        return count > 0 ? Result.success() : Result.fail(ResultCode.FAIL, "删除农场失败");
    }
}