package com.jp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jp.po.ItemsCustom;
import com.jp.po.ItemsQueryVo;
import com.jp.service.ItemsService;

/**
 * @ClassName:  ItemsController   
 * @Description:TODO(商品的Controller)   
 * @author      ZJP
 * @date:2018年1月30日 下午9:01:09
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	// 商品查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception { 
		// 调用service查找 数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}
	//商品修改
	@RequestMapping(value="/editItems", method={RequestMethod.GET,RequestMethod.POST})
	public String editItems(Model model,@RequestParam(value="id")Integer id) throws Exception{
		
		//调用service
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		
		model.addAttribute("itemsCustom", itemsCustom);

		return "items/editItems";
	}	
	//商品修改提交
	@RequestMapping("/editItemsSubmit")
	public void editItemsSubmit(HttpServletRequest request,HttpServletResponse resopnse,
			Integer id,ItemsQueryVo itemsQueryVo) throws Exception{
		
		System.out.println(itemsQueryVo.getItemsCustom().getName());
		//调用service，接受页面传入items，修改
		itemsService.updateItems(id, itemsQueryVo.getItemsCustom());
		//重定向
		//return "redirect:queryItems.action";
		//页面转发，url不变，可共享request
		//return "forward:queryItems.action";

		request.getRequestDispatcher("queryItems.action").forward(request, resopnse);
		//resopnse.sendRedirect("queryItems.action");
	}
	// 批量删除 商品信息
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception {

		// 调用service批量删除商品
		itemsService.deleteItems(items_id);

		return "redirect:queryItems.action";

	}
	// 批量修改商品页面，将商品信息查询出来，在页面中可以编辑商品信息
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request,
			ItemsQueryVo itemsQueryVo) throws Exception {

		// 调用service查找 数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		modelAndView.setViewName("items/editItemsQuery");

		return modelAndView;

	}

	// 批量修改商品提交
	// 通过ItemsQueryVo接收批量提交的商品信息，将商品信息存储到itemsQueryVo中itemsList属性中。
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo)
			throws Exception {
		System.out.println(itemsQueryVo.getItemsList());
		//获取到的list中的   id  为空
		////////////////////////
		////////怎么 获取id////////
		////////////////////////
		itemsService.editItems(itemsQueryVo.getItemsList());
		
		return "redirect:editItemsQuery.action";
	}

}
