package org.fh.shop.admin.mays.api.product;

import java.io.Serializable;

/**
 * 类名: ProductVo
 * 描述：
 *
 * @author
 * @create 2019-03-14 20:19
 **/

public class ProductVo implements Serializable {

    private static final long serialVersionUID = -5385187677727902364L;

    private Integer id;
    private String productName;
    private String brandName;
    private String shopName;
    private Double costPrice;
    private Double marketPrice;
    private Double repertory;
    private Integer recommend; //【0：否 1：是】,
    //图片
    private String imagePath;

    private String createTimeStr;
    private String updateTimeStr;

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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }
}
