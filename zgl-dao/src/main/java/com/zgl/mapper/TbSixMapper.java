package com.zgl.mapper;

import com.zgl.pojo.TbSix;
import com.zgl.pojo.TbSixExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSixMapper {
    long countByExample(TbSixExample example);

    int deleteByExample(TbSixExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSix record);

    int insertSelective(TbSix record);

    List<TbSix> selectByExample(TbSixExample example);

    TbSix selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSix record, @Param("example") TbSixExample example);

    int updateByExample(@Param("record") TbSix record, @Param("example") TbSixExample example);

    int updateByPrimaryKeySelective(TbSix record);

    int updateByPrimaryKey(TbSix record);
}