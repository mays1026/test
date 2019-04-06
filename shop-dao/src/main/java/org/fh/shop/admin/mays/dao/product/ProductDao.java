/** 
 * <pre>项目名称:lalal 
 * 文件名称:ProductDao.java 
 * 包名:com.fh.dao.product 
 * 创建日期:2019年1月27日下午2:16:41 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.dao.product;

import java.util.List;

import org.fh.shop.admin.mays.model.product.ProductInfo;

/** 
 * <pre>项目名称：lalal    
 * 类名称：ProductDao    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月27日 下午2:16:41    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月27日 下午2:16:41    
 * 修改备注：       
 * @version </pre>    
 */
public interface ProductDao {

	/** <pre>countListSize(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午2:29:40    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午2:29:40    
	 * 修改备注： 
	 * @param productInfo
	 * @return</pre>
	 */
	Long countListSize(ProductInfo productInfo);

	/** <pre>findProductList(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午2:29:44    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午2:29:44    
	 * 修改备注： 
	 * @param productInfo
	 * @return</pre>    
	 */
	List<ProductInfo> findProductList(ProductInfo productInfo);

	/** <pre>addProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午9:09:29    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午9:09:29    
	 * 修改备注： 
	 * @param productInfo</pre>    
	 */
	void addProduct(ProductInfo productInfo);

	/** <pre>updateProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午9:09:34    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午9:09:34    
	 * 修改备注： 
	 * @param productInfo</pre>    
	 */
	void updateProduct(ProductInfo productInfo);

	/** <pre>deleteAllData(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午9:09:38    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午9:09:38    
	 * 修改备注： 
	 * @param list</pre>    
	 */
	void deleteAllData(List<Integer> list);

	/** <pre>toupdateProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月28日 下午9:54:49    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月28日 下午9:54:49    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	ProductInfo toupdateProduct(Integer id);

	/** <pre>toupdateProduct(这里用一句话描述这个方法的作用)
	 * 创建人：马优生 178249290@qq.com
	 * 创建时间：2019年1月28日 下午9:54:49
	 * 修改人：马优生 178249290@qq.com
	 * 修改时间：2019年1月28日 下午9:54:49
	 * 修改备注：
	 * @param id
	 * @return</pre>
	 */
    List<ProductInfo> findExportData(ProductInfo productInfo);

    List<ProductInfo> findExportByBrandData(ProductInfo productInfo);

    List<ProductInfo> ajaxFindProductList(ProductInfo productInfo);

    void deleteProduct(Integer id);

    List<ProductInfo> findProductListApi();
}
