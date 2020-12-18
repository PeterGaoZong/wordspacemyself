package com.zgl.mapper;

import com.zgl.pojo.TbEleven;
import com.zgl.pojo.TbElevenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElevenMapper {
    long countByExample(TbElevenExample example);

    int deleteByExample(TbElevenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbEleven record);

    int insertSelective(TbEleven record);

    List<TbEleven> selectByExample(TbElevenExample example);

    TbEleven selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbEleven record, @Param("example") TbElevenExample example);

    int updateByExample(@Param("record") TbEleven record, @Param("example") TbElevenExample example);

    int updateByPrimaryKeySelective(TbEleven record);

    int updateByPrimaryKey(TbEleven record);
}