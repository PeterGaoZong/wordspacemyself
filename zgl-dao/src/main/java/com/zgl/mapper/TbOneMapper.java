package com.zgl.mapper;

import com.zgl.pojo.TbOne;
import com.zgl.pojo.TbOneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOneMapper {
    long countByExample(TbOneExample example);

    int deleteByExample(TbOneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbOne record);

    int insertSelective(TbOne record);

    List<TbOne> selectByExample(TbOneExample example);

    TbOne selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbOne record, @Param("example") TbOneExample example);

    int updateByExample(@Param("record") TbOne record, @Param("example") TbOneExample example);

    int updateByPrimaryKeySelective(TbOne record);

    int updateByPrimaryKey(TbOne record);
}