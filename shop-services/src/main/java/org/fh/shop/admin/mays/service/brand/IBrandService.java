/** 
 * <pre>项目名称:lalal 
 * 文件名称:IBrandService.java 
 * 包名:com.fh.service.brand 
 * 创建日期:2019年1月27日下午7:14:05 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.service.brand;

import org.fh.shop.admin.mays.model.brand.BrandInfo;

import java.util.List;

/** 
 * <pre>项目名称：lalal    
 * 类名称：IBrandService    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月27日 下午7:14:05    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月27日 下午7:14:05    
 * 修改备注：       
 * @version </pre>    
 */
public interface IBrandService {

	/** <pre>countListSize(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午7:20:22    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午7:20:22    
	 * 修改备注： 
	 * @param brandInfo
	 * @return</pre>    
	 */
	Long countListSize(BrandInfo brandInfo);

	/** <pre>findProductList(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午7:20:26    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午7:20:26    
	 * 修改备注： 
	 * @param brandInfo
	 * @return</pre>    
	 */
	List<BrandInfo> findBrandList(BrandInfo brandInfo);

	/** <pre>addBrand(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午7:48:43    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午7:48:43    
	 * 修改备注： 
	 * @param brandInfo</pre>    
	 */
	void addBrand(BrandInfo brandInfo);

	/** <pre>updateBrand(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午7:57:06    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午7:57:06    
	 * 修改备注： 
	 * @param brandInfo</pre>    
	 */
	void updateBrand(BrandInfo brandInfo);

	/** <pre>deleteAllData(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午7:57:11    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午7:57:11    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	void deleteAllData(String ids);

	/** <pre>initBrandList(这里用一句话描述这个方法的作用)
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月28日 下午8:28:32    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月28日 下午8:28:32    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<BrandInfo> initBrandList();

}
