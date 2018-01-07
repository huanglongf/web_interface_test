package com.sasha.service;

import com.sasha.pojo.BaseDict;

import java.util.List;

/**
 * Created by Andy on 2018/1/1.
 */
public interface BaseDictService {
    public List<BaseDict> findBaseDictWithTypeCode(String typeCode);
}
