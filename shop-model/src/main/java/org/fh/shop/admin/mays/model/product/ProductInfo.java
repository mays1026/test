/** 
 * <pre>项目名称:lalal 
 * 文件名称:ProductInfo.java 
 * 包名:com.fh.bean.product 
 * 创建日期:2019年1月27日下午1:59:11 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.model.product;

import org.fh.shop.admin.mays.model.PageInfo;
import org.fh.shop.admin.mays.model.brand.BrandInfo;
import org.fh.shop.admin.mays.model.shop.ShopInfo;

import java.io.Serializable;

/** 
 * <pre>项目名称：lalal    
 * 类名称：ProductInfo    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月27日 下午1:59:11    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月27日 下午1:59:11    
 * 修改备注：       
 * @version </pre>    
 */
public class ProductInfo extends PageInfo implements Serializable{

	private static final long serialVersionUID = -3445064208787347208L;
	//  id,商品名，品牌id,店铺id,商品成本价，商品销售价，商品库存，商品推荐【0：否 1：是】,
//	   商品录入时间，商品修改时间
	private Integer id;
	private String productName;
	private BrandInfo brandId = new BrandInfo();
	private ShopInfo shopId = new ShopInfo();
	private Double costPrice;
	private Double marketPrice;
	private Double repertory;
	private Integer recommend; //【0：否 1：是】,
	//图片
	private String imagePath;
	private String oldImagePath;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	//	成本价格范围查询
	private Double minCostPrice;
	private Double maxCostPrice;
//	销售价格范围查询
	private Double minMarketPrice;
	private Double maxMarketPrice;
//	库存范围查询
	private Double minRepertory;
	private Double maxRepertory;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BrandInfo getBrandId() {
		return brandId;
	}
	public void setBrandId(BrandInfo brandId) {
		this.brandId = brandId;
	}
	public ShopInfo getShopId() {
		return shopId;
	}
	public void setShopId(ShopInfo shopId) {
		this.shopId = shopId;
	}
	public Double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	public Double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Double getRepertory() {
		return repertory;
	}
	public void setRepertory(Double repertory) {
		this.repertory = repertory;
	}
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	public Double getMinCostPrice() {
		return minCostPrice;
	}
	public void setMinCostPrice(Double minCostPrice) {
		this.minCostPrice = minCostPrice;
	}
	public Double getMaxCostPrice() {
		return maxCostPrice;
	}
	public void setMaxCostPrice(Double maxCostPrice) {
		this.maxCostPrice = maxCostPrice;
	}
	public Double getMinMarketPrice() {
		return minMarketPrice;
	}
	public void setMinMarketPrice(Double minMarketPrice) {
		this.minMarketPrice = minMarketPrice;
	}
	public Double getMaxMarketPrice() {
		return maxMarketPrice;
	}
	public void setMaxMarketPrice(Double maxMarketPrice) {
		this.maxMarketPrice = maxMarketPrice;
	}
	public Double getMinRepertory() {
		return minRepertory;
	}
	public void setMinRepertory(Double minRepertory) {
		this.minRepertory = minRepertory;
	}
	public Double getMaxRepertory() {
		return maxRepertory;
	}
	public void setMaxRepertory(Double maxRepertory) {
		this.maxRepertory = maxRepertory;
	}

	public String getOldImagePath() {
		return oldImagePath;
	}

	public void setOldImagePath(String oldImagePath) {
		this.oldImagePath = oldImagePath;
	}

	@Override
	public String toString() {
		return "ProductInfo{" +
				"id=" + id +
				", productName='" + productName + '\'' +
				", brandId=" + brandId +
				", shopId=" + shopId +
				", costPrice=" + costPrice +
				", marketPrice=" + marketPrice +
				", repertory=" + repertory +
				", recommend=" + recommend +
				", imagePath='" + imagePath + '\'' +
				", oldImagePath='" + oldImagePath + '\'' +
				", minCostPrice=" + minCostPrice +
				", maxCostPrice=" + maxCostPrice +
				", minMarketPrice=" + minMarketPrice +
				", maxMarketPrice=" + maxMarketPrice +
				", minRepertory=" + minRepertory +
				", maxRepertory=" + maxRepertory +
				'}';
	}
}
