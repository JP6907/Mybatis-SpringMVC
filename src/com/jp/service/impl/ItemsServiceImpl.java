package com.jp.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jp.mapper.ItemsMapper;
import com.jp.mapper.ItemsMapperCustom;
import com.jp.po.Items;
import com.jp.po.ItemsCustom;
import com.jp.po.ItemsQueryVo;
import com.jp.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		//对items进行业务处理
		//......
		//返回ItemsCustom
		ItemsCustom itemsCustom = new ItemsCustom();
		//拷贝属性值
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//添加业务校验，通常在service接口对关键参数进行校验
		//检验id是否为空，若空，则抛出异常

		//更新商品信息
		//updateByPrimaryKeyWithBLOBs可以根据id更新表中所有字段，包括大文本text类型
		//updateByPrimaryKeyWithBLOBs必须传入id
		//updateByPrimaryKeySelective不为空则更新
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}

	@Override
	public void deleteItems(Integer[] items_id) throws Exception {
		// TODO Auto-generated method stub
		for(int id:items_id){
			itemsMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void editItems(List<ItemsCustom> itemsList) throws Exception {
		// TODO Auto-generated method stub
		for(ItemsCustom item:itemsList){
			itemsMapper.updateByPrimaryKeySelective(item);
		}
	}

}
