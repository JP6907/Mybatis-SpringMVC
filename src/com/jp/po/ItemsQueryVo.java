package com.jp.po;

import java.util.List;

/**
 * @ClassName:  ItemsQueryVo   
 * @Description:TODO(商品包装对象)   
 * @author      ZJP
 * @date:2018年1月30日 下午8:01:51
 */
public class ItemsQueryVo {
	//商品信息
	private Items items;
	//为了系统的可拓展性，对原始po进行扩展
	private ItemsCustom itemsCustom;
	//批量修改商品列表
	private List<ItemsCustom> itemsList;
	
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}
	

}
