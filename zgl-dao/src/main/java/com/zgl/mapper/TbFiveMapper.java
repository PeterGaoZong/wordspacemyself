package com.zgl.mapper;

import com.zgl.pojo.TbFive;
import com.zgl.pojo.TbFiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFiveMapper {
    long countByExample(TbFiveExample example);

    int deleteByExample(TbFiveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFive record);

    int insertSelective(TbFive record);

    List<TbFive> selectByExample(TbFiveExample example);

    TbFive selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFive record, @Param("example") TbFiveExample example);

    int updateByExample(@Param("record") TbFive record, @Param("example") TbFiveExample example);

    int updateByPrimaryKeySelective(TbFive record);

    int updateByPrimaryKey(TbFive record);
}