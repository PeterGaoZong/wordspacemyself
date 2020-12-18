package com.zgl.mapper;

import com.zgl.pojo.TbSeven;
import com.zgl.pojo.TbSevenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSevenMapper {
    long countByExample(TbSevenExample example);

    int deleteByExample(TbSevenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSeven record);

    int insertSelective(TbSeven record);

    List<TbSeven> selectByExample(TbSevenExample example);

    TbSeven selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSeven record, @Param("example") TbSevenExample example);

    int updateByExample(@Param("record") TbSeven record, @Param("example") TbSevenExample example);

    int updateByPrimaryKeySelective(TbSeven record);

    int updateByPrimaryKey(TbSeven record);
}