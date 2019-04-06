package org.fh.shop.admin.mays.model.images;

import org.fh.shop.admin.mays.model.product.ProductInfo;

import java.io.Serializable;

/**
 * 类名: ImagesInfo
 * 描述：
 *
 * @author
 * @create 2019-02-17 19:17
 **/

public class ImagesInfo implements Serializable {
    private static final long serialVersionUID = 739875333888418081L;
    private Integer id;
    private String imgPath;
    private ProductInfo productInfo = new ProductInfo();

    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    @Override
    public String toString() {
        return "ImagesInfo{" +
                "id=" + id +
                ", imgPath='" + imgPath + '\'' +
                ", productInfo=" + productInfo +
                ", ids='" + ids + '\'' +
                '}';
    }
}
