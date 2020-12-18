package com.zgl.mapper;

import com.zgl.pojo.TbThree;
import com.zgl.pojo.TbThreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbThreeMapper {
    long countByExample(TbThreeExample example);

    int deleteByExample(TbThreeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbThree record);

    int insertSelective(TbThree record);

    List<TbThree> selectByExample(TbThreeExample example);

    TbThree selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbThree record, @Param("example") TbThreeExample example);

    int updateByExample(@Param("record") TbThree record, @Param("example") TbThreeExample example);

    int updateByPrimaryKeySelective(TbThree record);

    int updateByPrimaryKey(TbThree record);
}