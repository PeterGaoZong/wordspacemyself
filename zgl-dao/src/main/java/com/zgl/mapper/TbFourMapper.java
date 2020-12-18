package com.zgl.mapper;

import com.zgl.pojo.TbFour;
import com.zgl.pojo.TbFourExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFourMapper {
    long countByExample(TbFourExample example);

    int deleteByExample(TbFourExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFour record);

    int insertSelective(TbFour record);

    List<TbFour> selectByExample(TbFourExample example);

    TbFour selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFour record, @Param("example") TbFourExample example);

    int updateByExample(@Param("record") TbFour record, @Param("example") TbFourExample example);

    int updateByPrimaryKeySelective(TbFour record);

    int updateByPrimaryKey(TbFour record);
}