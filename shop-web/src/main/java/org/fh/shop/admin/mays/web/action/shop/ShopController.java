/** 
s * <pre>项目名称:lalal 
 * 文件名称:ShopController.java 
 * 包名:com.fh.controller.shop 
 * 创建日期:2019年1月25日下午7:50:00 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.web.action.shop;

import java.util.List;

import javax.annotation.Resource;

import org.fh.shop.admin.mays.annontation.Log;
import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.model.brand.BrandInfo;
import org.fh.shop.admin.mays.model.shop.ShopInfo;
import org.fh.shop.admin.mays.service.shop.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/** 
 * <pre>项目名称：lalal    
 * 类名称：ShopController    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月25日 下午7:50:00    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月25日 下午7:50:00    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Resource
	private ShopService shopService;
	
	/**
	 * <pre>toQueryPage(跳转到查询页面)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月26日 下午9:52:38    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月26日 下午9:52:38    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/toShopQueryPage")
	public String toQueryPage() {
		return "shop/shopList";
	}
	
	/**
	 * <pre>findShopList(条件分页查询)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月25日 下午8:02:56    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月25日 下午8:02:56    
	 * 修改备注： </pre>
	 */
	@RequestMapping("findShopList")
	public String findShopList(ShopInfo shopInfo, ModelMap map, Integer flag) {
		//计算分页条数
		Long count = shopService.countListSize(shopInfo);
		shopInfo.setTotalCount(count);
		//计算分页信息
		shopInfo.calculatePage();
		//获取列表
		List<ShopInfo> list = shopService.findShopList(shopInfo);
		map.put("list", list);
		map.put("page", shopInfo);
		if (flag == null) {
			return "shop/shopList";
		}
		return "shop/shopPage";
	}
	
	/**
	 * <pre>toAddShop(跳转添加页面)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月26日 下午10:21:48    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月26日 下午10:21:48    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("toAddShop")
	public String toAddShop() {
		return "shop/addShop";
	}
	
	/**
	 * <pre>addShop(新增)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月26日 下午10:22:35    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月26日 下午10:22:35    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("addShop")
	@Log("添加shop数据")
	public String addShop(ShopInfo shopInfo) {
		shopService.addShop(shopInfo);
		return "redirect:/shop/findShopList.action";
	}

	/**
	 * <pre>deleteAllData(批量删除)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月26日 下午10:55:20    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月26日 下午10:55:20    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("deleteAllData")
	@ResponseBody
	@Log("删除shop数据")
	public ServiceResponse deleteAllData(String ids) {
		shopService.deleteAllData(ids);
		return ServiceResponse.success();
	}
	
	/**
	 * <pre>toUpdateShop(回显)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月26日 下午11:23:38    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月26日 下午11:23:38    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("toUpdateShop")
	public ModelAndView toUpdateShop(Integer id) {
		ModelAndView mav = new ModelAndView("shop/updateShop");
		ShopInfo shopInfo = shopService.toUpdateShop(id);
		mav.addObject(shopInfo);
		return mav;
	}
	
	/**
	 * <pre>updataShop(修改)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月26日 下午11:34:04    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月26日 下午11:34:04    
	 * 修改备注： 
	 * @param shopInfo
	 * @return</pre>
	 */
	@RequestMapping("updataShop")
	@Log("修改shop数据")
	public String updataShop(ShopInfo shopInfo) {
		shopService.updataShop(shopInfo);
		return "redirect:/shop/findShopList.action";
	}
	
	/**
	 * <pre>initShopList(下拉框)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月28日 下午8:27:17    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月28日 下午8:27:17    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("initShopList")
	@ResponseBody
	public ServiceResponse initShopList() {
		List<BrandInfo> list = shopService.initShopList();
		return ServiceResponse.success(list);
	}
	
}
