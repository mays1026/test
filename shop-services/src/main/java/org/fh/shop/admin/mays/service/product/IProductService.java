/** 
 * <pre>项目名称:lalal 
 * 文件名称:IProductService.java 
 * 包名:com.fh.service.product 
 * 创建日期:2019年1月27日下午2:14:47 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.service.product;

import org.fh.shop.admin.mays.model.images.ImagesInfo;
import org.fh.shop.admin.mays.model.product.ProductInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/** 
 * <pre>项目名称：lalal    
 * 类名称：IProductService    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月27日 下午2:14:47    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月27日 下午2:14:47    
 * 修改备注：       
 * @version </pre>    
 */
public interface IProductService {

	/** <pre>countListSize(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午2:24:15    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午2:24:15    
	 * 修改备注： 
	 * @param productInfo
	 * @return</pre>    
	 */
	Long countListSize(ProductInfo productInfo);

	/** <pre>findProductList(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午2:27:50    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午2:27:50    
	 * 修改备注： 
	 * @param productInfo
	 * @return</pre>    
	 */
	List<ProductInfo> findProductList(ProductInfo productInfo);

	/** <pre>addProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午9:01:55    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午9:01:55    
	 * 修改备注： 
	 * @param productInfo</pre>    
	 */
	void addProduct(ProductInfo productInfo, String imgPath);


	/** <pre>updateProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午9:06:26    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午9:06:26    
	 * 修改备注： 
	 * @param productInfo</pre>    
	 */
	void updateProduct(ProductInfo productInfo, ImagesInfo imagesInfo);

	/** <pre>deleteAllData(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月27日 下午9:06:38    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月27日 下午9:06:38    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	void deleteAllData(String ids);

	/** <pre>toupdateProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月28日 下午9:54:12    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月28日 下午9:54:12    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	ProductInfo toupdateProduct(Integer id);

	/** <pre>toupdateProduct(这里用一句话描述这个方法的作用)
	 * 创建人：马优生 178249290@qq.com
	 * 创建时间：2019年1月28日 下午9:54:12
	 * 修改人：马优生 178249290@qq.com
	 * 修改时间：2019年1月28日 下午9:54:12
	 * 修改备注：
	 * @return</pre>
	 */
    List<ProductInfo> findExportData(ProductInfo productInfo);

    List<ProductInfo> findExportByBrandData(ProductInfo productInfo);

	void uploadProductImg(ProductInfo productInfo, MultipartFile imagesFile);

    List<ProductInfo> ajaxFindProductList(ProductInfo productInfo);

    void deleteProduct(Integer id);

    List<ProductInfo> findProductListApi();
}
