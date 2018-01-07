package com.sasha.service.impl;

import com.sasha.mapper.BaseDictMapper;
import com.sasha.pojo.BaseDict;
import com.sasha.pojo.BaseDictExample;
import com.sasha.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Andy on 2018/1/1.
 *
 */
@Service
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictMapper baseDictMapper;


    @Override
    public List<BaseDict> findBaseDictWithTypeCode(String typeCode) {

        BaseDictExample example = new BaseDictExample();
        BaseDictExample.Criteria criteria = example.createCriteria();
        criteria.andDictEnableEqualTo("1");
        criteria.andDictTypeCodeEqualTo(typeCode);
        example.setOrderByClause("dict_sort");

        List<BaseDict> list = baseDictMapper.selectByExample(example);

        return list;
    }
}
