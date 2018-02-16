package com.jp.mapper;

import com.jp.po.ItemsCustom;
import com.jp.po.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}