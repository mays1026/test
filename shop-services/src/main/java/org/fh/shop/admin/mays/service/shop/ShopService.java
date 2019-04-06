/** 
 * <pre>项目名称:lalal 
 * 文件名称:IShopService.java 
 * 包名:com.fh.service.shop 
 * 创建日期:2019年1月25日下午7:59:32 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.service.shop;

import java.util.List;

import org.fh.shop.admin.mays.model.brand.BrandInfo;
import org.fh.shop.admin.mays.model.shop.ShopInfo;

/** 
 * <pre>项目名称：lalal    
 * 类名称：IShopService    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月25日 下午7:59:32    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月25日 下午7:59:32    
 * 修改备注：       
 * @version </pre>    
 */
public interface ShopService {

	/** <pre>countListSize(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月25日 下午8:36:41    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月25日 下午8:36:41    
	 * 修改备注： 
	 * @param shopInfo 
	 * @return</pre>    
	 */
	Long countListSize(ShopInfo shopInfo);

	/** <pre>findShopList(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月25日 下午8:58:15    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月25日 下午8:58:15    
	 * 修改备注： 
	 * @param shopInfo
	 * @return</pre>    
	 */
	List<ShopInfo> findShopList(ShopInfo shopInfo);

	/** <pre>addShop(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月26日 下午10:25:27    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月26日 下午10:25:27    
	 * 修改备注： 
	 * @param shopInfo</pre>    
	 */
	void addShop(ShopInfo shopInfo);

	/** <pre>deleteAllData(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月26日 下午10:56:19    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月26日 下午10:56:19    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	void deleteAllData(String ids);

	/** <pre>toUpdateShop(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月26日 下午11:24:30    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月26日 下午11:24:30    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	ShopInfo toUpdateShop(Integer id);

	/** <pre>updataShop(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月26日 下午11:34:14    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月26日 下午11:34:14    
	 * 修改备注： 
	 * @param shopInfo</pre>    
	 */
	void updataShop(ShopInfo shopInfo);

	/** <pre>initShopList(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月28日 下午8:30:08    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月28日 下午8:30:08    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<BrandInfo> initShopList();

}
