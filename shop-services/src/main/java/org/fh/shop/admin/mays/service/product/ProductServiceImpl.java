/**
 * <pre>项目名称:lalal
 * 文件名称:ProductServiceImpl.java
 * 包名:com.fh.service.product
 * 创建日期:2019年1月27日下午2:15:30
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre>
 */
package org.fh.shop.admin.mays.service.product;

import org.apache.commons.lang3.StringUtils;
import org.fh.shop.admin.mays.common.WebContextThreadLocal;
import org.fh.shop.admin.mays.dao.product.IImagesDao;
import org.fh.shop.admin.mays.dao.product.ProductDao;
import org.fh.shop.admin.mays.model.images.ImagesInfo;
import org.fh.shop.admin.mays.model.product.ProductInfo;
import org.fh.shop.admin.mays.util.DateUtils;
import org.fh.shop.admin.mays.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>项目名称：lalal
 * 类名称：ProductServiceImpl
 * 类描述：
 * 创建人：马优生 178249290@qq.com
 * 创建时间：2019年1月27日 下午2:15:30
 * 修改人：马优生 178249290@qq.com
 * 修改时间：2019年1月27日 下午2:15:30
 * 修改备注：
 * @version </pre>
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private IImagesDao imagesDao;

    /* (non-Javadoc)
     * @see com.fh.service.product.IProductService#countListSize(com.fh.bean.product.ProductInfo)
     */
    @Override
    public Long countListSize(ProductInfo productInfo) {
        return productDao.countListSize(productInfo);
    }

    /* (non-Javadoc)
     * @see com.fh.service.product.IProductService#findProductList(com.fh.bean.product.ProductInfo)
     */
    @Override
    public List<ProductInfo> findProductList(ProductInfo productInfo) {
        return productDao.findProductList(productInfo);
    }

    /* (non-Javadoc)
     * @see com.fh.service.product.IProductService#addProduct(com.fh.bean.product.ProductInfo)
     */
    @Override
    public void addProduct(ProductInfo productInfo, String imgPath) {
        Date dateNow = DateUtils.getDateNow();
        productInfo.setCreateTime(dateNow);
        productDao.addProduct(productInfo);
        updateImagesInfo(productInfo, imgPath);
    }

    /* (non-Javadoc)
     * @see com.fh.service.product.IProductService#updateProduct(com.fh.bean.product.ProductInfo)
     */
    @Override
    public void updateProduct(ProductInfo productInfo, ImagesInfo imagesInfo) {
        //删除图片表信息
        String ids = imagesInfo.getIds();
        deleteImageInfoAndFile(ids);
        //更新图片表上传图片
        if (StringUtils.isNotEmpty(productInfo.getOldImagePath())) {
            productInfo.setImagePath(productInfo.getOldImagePath());
        }
        if (StringUtils.isNotEmpty(imagesInfo.getImgPath())) {
            updateImagesInfo(productInfo, imagesInfo.getImgPath());
        }
        productInfo.setUpdateTime(DateUtils.getDateNow());
        productDao.updateProduct(productInfo);
    }

    /* (non-Javadoc)
     * @see com.fh.service.product.IProductService#deleteAllData(java.lang.String)
     */
    @Override
    public void deleteAllData(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] idArr = ids.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < idArr.length; i++) {
                list.add(Integer.parseInt(idArr[i]));
            }
            productDao.deleteAllData(list);
        }
    }

    /* (non-Javadoc)
     * @see com.fh.service.product.IProductService#toupdateProduct(java.lang.Integer)
     */
    @Override
    public ProductInfo toupdateProduct(Integer id) {
        return productDao.toupdateProduct(id);
    }

    @Override
    public List<ProductInfo> findExportData(ProductInfo productInfo) {
        return productDao.findExportData(productInfo);
    }

    @Override
    public List<ProductInfo> findExportByBrandData(ProductInfo productInfo) {
        return productDao.findExportByBrandData(productInfo);
    }

    /**
     * 删除图片表信息
     *
     * @param ids
     */

    public void deleteImageInfoAndFile(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String fileRealPath = WebContextThreadLocal.getRequest().getServletContext().getRealPath("/");
            String[] idsArr = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (int i = 0; i < idsArr.length; i++) {
                idList.add(Integer.parseInt(idsArr[i]));
            }
            //删除图片表图片
            List<ImagesInfo> imgList = imagesDao.findImagesPathByImageIds(idList);
            for (int i = 0; i < imgList.size(); i++) {
                String filePath = fileRealPath + imgList.get(i).getImgPath();
                FileUtil.deleteFile(filePath);
            }
            imagesDao.deleteImages(idList);
        }
    }

    @Override
    public void uploadProductImg(ProductInfo productInfo, @RequestParam MultipartFile imagesFile) {
        //更新主图片
        if (!imagesFile.isEmpty() && imagesFile.getSize() > 0) {
            //删除旧图片
            FileUtil.deleteFile(WebContextThreadLocal.getRequest().getServletContext().getRealPath("/") + productInfo.getImagePath());
            //上传主图片
            String filePath = FileUtil.uploadFile(imagesFile);
            productInfo.setImagePath(filePath);
        }
    }

    @Override
    public List<ProductInfo> ajaxFindProductList(ProductInfo productInfo) {
        return productDao.ajaxFindProductList(productInfo);
    }

    @Override
    public void deleteProduct(Integer id) {
        productDao.deleteProduct(id);
    }

    @Override
    public List<ProductInfo> findProductListApi() {
        return productDao.findProductListApi();
    }


    /**
     * 更新图片表
     *
     * @param productInfo
     */
    public void updateImagesInfo(ProductInfo productInfo, String imgPath) {
        //批量插入图片表信息
        if (StringUtils.isNotEmpty(imgPath)) {
            String[] split = imgPath.split(",");
            List<ImagesInfo> list = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                ImagesInfo imagesInfo = new ImagesInfo();
                imagesInfo.setProductInfo(productInfo);
                imagesInfo.setImgPath(split[i]);
                list.add(imagesInfo);
            }
            imagesDao.addImages(list);
        }
    }

    /**
     * 获取imagesInfo对象
     *
     * @param productId product的id
     * @param imgPath   图片路径
     * @return
     */
    public ImagesInfo getImagesInfo(Integer productId, String imgPath) {
        ImagesInfo imagesInfo = new ImagesInfo();
        imagesInfo.getProductInfo().setId(productId);
        imagesInfo.setImgPath(imgPath);
        return imagesInfo;
    }


}
