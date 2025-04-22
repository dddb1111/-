package org.example.formsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.formsystem.entity.FertilizersAndPesticides;

import java.util.List;

@Mapper
public interface FertilizersAndPesticidesMapper {
    List<FertilizersAndPesticides> selectAll();
    FertilizersAndPesticides selectById(Integer id);
    int insert(FertilizersAndPesticides fertilizersAndPesticides);
    int update(FertilizersAndPesticides fertilizersAndPesticides);
    int deleteById(Integer id);
}
