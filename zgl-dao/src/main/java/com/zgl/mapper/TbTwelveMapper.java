package com.zgl.mapper;

import com.zgl.pojo.TbTwelve;
import com.zgl.pojo.TbTwelveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTwelveMapper {
    long countByExample(TbTwelveExample example);

    int deleteByExample(TbTwelveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTwelve record);

    int insertSelective(TbTwelve record);

    List<TbTwelve> selectByExample(TbTwelveExample example);

    TbTwelve selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTwelve record, @Param("example") TbTwelveExample example);

    int updateByExample(@Param("record") TbTwelve record, @Param("example") TbTwelveExample example);

    int updateByPrimaryKeySelective(TbTwelve record);

    int updateByPrimaryKey(TbTwelve record);
}