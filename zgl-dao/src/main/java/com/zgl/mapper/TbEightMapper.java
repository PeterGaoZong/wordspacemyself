package com.zgl.mapper;

import com.zgl.pojo.TbEight;
import com.zgl.pojo.TbEightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEightMapper {
    long countByExample(TbEightExample example);

    int deleteByExample(TbEightExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbEight record);

    int insertSelective(TbEight record);

    List<TbEight> selectByExample(TbEightExample example);

    TbEight selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbEight record, @Param("example") TbEightExample example);

    int updateByExample(@Param("record") TbEight record, @Param("example") TbEightExample example);

    int updateByPrimaryKeySelective(TbEight record);

    int updateByPrimaryKey(TbEight record);
}