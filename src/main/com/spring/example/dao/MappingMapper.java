package com.spring.example.dao;

import com.spring.example.entity.Mapping;
import com.spring.example.entity.MappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MappingMapper {
    int countByExample(MappingExample example);

    int deleteByExample(MappingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Mapping record);

    int insertSelective(Mapping record);

    List<Mapping> selectByExample(MappingExample example);

    Mapping selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Mapping record, @Param("example") MappingExample example);

    int updateByExample(@Param("record") Mapping record, @Param("example") MappingExample example);

    int updateByPrimaryKeySelective(Mapping record);

    int updateByPrimaryKey(Mapping record);
}