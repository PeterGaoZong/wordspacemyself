package com.zgl.mapper;

import com.zgl.pojo.TbTen;
import com.zgl.pojo.TbTenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTenMapper {
    long countByExample(TbTenExample example);

    int deleteByExample(TbTenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTen record);

    int insertSelective(TbTen record);

    List<TbTen> selectByExample(TbTenExample example);

    TbTen selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTen record, @Param("example") TbTenExample example);

    int updateByExample(@Param("record") TbTen record, @Param("example") TbTenExample example);

    int updateByPrimaryKeySelective(TbTen record);

    int updateByPrimaryKey(TbTen record);
}