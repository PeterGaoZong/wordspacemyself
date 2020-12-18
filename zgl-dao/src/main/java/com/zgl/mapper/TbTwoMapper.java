package com.zgl.mapper;

import com.zgl.pojo.TbTwo;
import com.zgl.pojo.TbTwoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTwoMapper {
    long countByExample(TbTwoExample example);

    int deleteByExample(TbTwoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTwo record);

    int insertSelective(TbTwo record);

    List<TbTwo> selectByExample(TbTwoExample example);

    TbTwo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTwo record, @Param("example") TbTwoExample example);

    int updateByExample(@Param("record") TbTwo record, @Param("example") TbTwoExample example);

    int updateByPrimaryKeySelective(TbTwo record);

    int updateByPrimaryKey(TbTwo record);
}