/** 
 * <pre>项目名称:lalal 
 * 文件名称:BrandDao.java 
 * 包名:com.fh.dao.brand 
 * 创建日期:2019年1月27日下午7:15:46 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.dao.brand;

import org.fh.shop.admin.mays.model.brand.BrandInfo;

import java.util.List;

/** 
 * <pre>项目名称：lalal    
 * 类名称：BrandDao    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月27日 下午7:15:46    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月27日 下午7:15:46    
 * 修改备注：       
 * @version </pre>    
 */
public interface BrandDao {

	/** <pre>countListSize(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午7:21:37    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午7:21:37    
	 * 修改备注： 
	 * @param brandInfo
	 * @return</pre>    
	 */
	Long countListSize(BrandInfo brandInfo);

	/** <pre>findProductList(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午7:21:42    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午7:21:42    
	 * 修改备注： 
	 * @param brandInfo
	 * @return</pre>    
	 */
	List<BrandInfo> findBrandList(BrandInfo brandInfo);
	
	/** <pre>addBrand(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午8:00:37    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午8:00:37    
	 * 修改备注： 
	 * @param brandInfo</pre>    
	 */
	void addBrand(BrandInfo brandInfo);

	/** <pre>updateBrand(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午8:00:25    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午8:00:25    
	 * 修改备注： 
	 * @param brandInfo</pre>    
	 */
	void updateBrand(BrandInfo brandInfo);

	/** <pre>deleteAllData(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午8:00:29    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午8:00:29    
	 * 修改备注： 
	 * @param list</pre>    
	 */
	void deleteAllData(List<Integer> list);

	/** <pre>initBrandList(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月28日 下午8:28:53    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月28日 下午8:28:53    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<BrandInfo> initBrandList();

}
