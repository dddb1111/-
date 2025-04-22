package org.example.formsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.formsystem.entity.Farms;

import java.util.List;

@Mapper
public interface FarmsMapper {
    // 查询所有农场
    List<Farms> selectAll();

    // 根据ID查询农场
    Farms selectById(Integer id);

    // 新增农场
    int insert(Farms farms);

    // 更新农场
    int update(Farms farms);

    // 删除农场
    int deleteById(Integer id);
}
