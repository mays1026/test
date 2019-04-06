/** 
 * <pre>项目名称:lalal 
 * 文件名称:ShopServiceImpl.java 
 * 包名:com.fh.service.shop 
 * 创建日期:2019年1月25日下午7:59:49 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.service.shop;

import org.apache.commons.lang3.StringUtils;
import org.fh.shop.admin.mays.dao.shop.ShopDao;
import org.fh.shop.admin.mays.model.brand.BrandInfo;
import org.fh.shop.admin.mays.model.shop.ShopInfo;
import org.fh.shop.admin.mays.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/** 
 * <pre>项目名称：lalal    
 * 类名称：ShopServiceImpl    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月25日 下午7:59:49    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月25日 下午7:59:49    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopDao shopDao;

	/* (non-Javadoc)    
	 * @see com.fh.service.shop.ShopService#countListSize()    
	 */
	@Override
	public Long countListSize(ShopInfo shopInfo) {
		return shopDao.countListSize(shopInfo);
	}

	/* (non-Javadoc)    
	 * @see com.fh.service.shop.ShopService#findShopList(com.fh.bean.shop.ShopInfo)    
	 */
	@Override
	public List<ShopInfo> findShopList(ShopInfo shopInfo) {
		return shopDao.findShopList(shopInfo);
	}

	/* (non-Javadoc)    
	 * @see com.fh.service.shop.ShopService#addShop(com.fh.bean.shop.ShopInfo)    
	 */
	@Override
	public void addShop(ShopInfo shopInfo) {
		shopInfo.setCreateTime(DateUtils.getDateNow());
		shopDao.addShop(shopInfo);
	}

	/* (non-Javadoc)    
	 * @see com.fh.service.shop.ShopService#deleteAllData(java.lang.String)    
	 */
	@Override
	public void deleteAllData(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			List<Integer> list = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (int i = 0; i < idArr.length; i++) {
				list.add(Integer.parseInt(idArr[i]));
			}
			shopDao.deleteAllData(list);
		}
	}

	/* (non-Javadoc)    
	 * @see com.fh.service.shop.ShopService#toUpdateShop(java.lang.Integer)    
	 */
	@Override
	public ShopInfo toUpdateShop(Integer id) {
		return shopDao.toUpdateShop(id);
	}

	/* (non-Javadoc)    
	 * @see com.fh.service.shop.ShopService#updataShop(com.fh.bean.shop.ShopInfo)    
	 */
	@Override
	public void updataShop(ShopInfo shopInfo) {
		shopDao.updataShop(shopInfo);
	}

	/* (non-Javadoc)    
	 * @see com.fh.service.shop.ShopService#initShopList()    
	 */
	@Override
	public List<BrandInfo> initShopList() {
		return shopDao.initShopList();
	}
}
