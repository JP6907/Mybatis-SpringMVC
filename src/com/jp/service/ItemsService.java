package com.jp.service;

import java.util.List;

import com.jp.po.ItemsCustom;
import com.jp.po.ItemsQueryVo;

public interface ItemsService {

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	/**
	 * 
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param id
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: ItemsCustom      
	 * @throws
	 */
	public ItemsCustom findItemsById(Integer id) throws Exception;
	/**
	 * @Description: TODO(修改商品信息)   
	 * @param: @param id 商品的id
	 * @param: @param itemsCustom 修改的商品信息
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	/**
	 * @Description: TODO(批量删除商品)   
	 * @param: @param items_id
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public void deleteItems(Integer[] items_id) throws Exception;
	/**
	 * @Description: TODO(批量修改商品)   
	 * @param: @param itemsList
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public void editItems(List<ItemsCustom> itemsList) throws Exception;

}
