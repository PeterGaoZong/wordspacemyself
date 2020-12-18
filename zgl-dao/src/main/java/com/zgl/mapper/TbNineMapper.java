package com.zgl.mapper;

import com.zgl.pojo.TbNine;
import com.zgl.pojo.TbNineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbNineMapper {
    long countByExample(TbNineExample example);

    int deleteByExample(TbNineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbNine record);

    int insertSelective(TbNine record);

    List<TbNine> selectByExample(TbNineExample example);

    TbNine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbNine record, @Param("example") TbNineExample example);

    int updateByExample(@Param("record") TbNine record, @Param("example") TbNineExample example);

    int updateByPrimaryKeySelective(TbNine record);

    int updateByPrimaryKey(TbNine record);
}