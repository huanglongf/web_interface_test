package com.sasha.mapper;

import cn.itcast.utils.Page;
import com.sasha.pojo.BaseDict;
import com.sasha.pojo.BaseDictExample;
import com.sasha.pojo.Customer;
import com.sasha.vo.QueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDictMapper {
    long countByExample(BaseDictExample example);

    int deleteByExample(BaseDictExample example);

    int deleteByPrimaryKey(String dictId);

    int insert(BaseDict record);

    int insertSelective(BaseDict record);

    List<BaseDict> selectByExample(BaseDictExample example);

    BaseDict selectByPrimaryKey(String dictId);

    int updateByExampleSelective(@Param("record") BaseDict record, @Param("example") BaseDictExample example);

    int updateByExample(@Param("record") BaseDict record, @Param("example") BaseDictExample example);

    int updateByPrimaryKeySelective(BaseDict record);

    int updateByPrimaryKey(BaseDict record);


}