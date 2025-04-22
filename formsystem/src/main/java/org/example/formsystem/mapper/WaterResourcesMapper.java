package org.example.formsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.formsystem.entity.WaterResources;

import java.util.List;

@Mapper
public interface WaterResourcesMapper {
    List<WaterResources> selectAll();
    WaterResources selectById(Integer id);
    int insert(WaterResources waterResources);
    int update(WaterResources waterResources);
    int deleteById(Integer id);
}
