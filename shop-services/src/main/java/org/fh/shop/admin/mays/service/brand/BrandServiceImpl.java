/**
 * <pre>项目名称:lalal
 * 文件名称:BrandServiceImpl.java
 * 包名:com.fh.service.brand
 * 创建日期:2019年1月27日下午7:14:55
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre>
 */
package org.fh.shop.admin.mays.service.brand;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.fh.shop.admin.mays.dao.brand.BrandDao;
import org.fh.shop.admin.mays.model.brand.BrandInfo;
import org.fh.shop.admin.mays.util.DateUtils;
import org.fh.shop.admin.mays.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>项目名称：lalal
 * 类名称：BrandServiceImpl
 * 类描述：
 * 创建人：马优生 178249290@qq.com
 * 创建时间：2019年1月27日 下午7:14:55
 * 修改人：马优生 178249290@qq.com
 * 修改时间：2019年1月27日 下午7:14:55
 * 修改备注：
 * @version </pre>
 */
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandDao brandDao;

    /* (non-Javadoc)
     * @see com.fh.service.brand.IBrandService#countListSize(com.fh.bean.brand.BrandInfo)
     */
    @Override
    public Long countListSize(BrandInfo brandInfo) {
        return brandDao.countListSize(brandInfo);
    }

    /* (non-Javadoc)
     * @see com.fh.service.brand.IBrandService#findProductList(com.fh.bean.brand.BrandInfo)
     */
    @Override
    public List<BrandInfo> findBrandList(BrandInfo brandInfo) {
        List<BrandInfo> brandList = brandDao.findBrandList(brandInfo);
        return brandList;
    }

    /* (non-Javadoc)
     * @see com.fh.service.brand.IBrandService#addBrand(com.fh.bean.brand.BrandInfo)
     */
    @Override
    public void addBrand(BrandInfo brandInfo) {
        Date dateNow = DateUtils.getDateNow();
        brandInfo.setUpdateTime(dateNow);
        brandInfo.setCreateTime(dateNow);
        brandDao.addBrand(brandInfo);
    }

    /* (non-Javadoc)
     * @see com.fh.service.brand.IBrandService#updateBrand(com.fh.bean.brand.BrandInfo)
     */
    @Override
    public void updateBrand(BrandInfo brandInfo) {
        brandInfo.setUpdateTime(DateUtils.getDateNow());
        brandDao.updateBrand(brandInfo);
    }

    /* (non-Javadoc)
     * @see com.fh.service.brand.IBrandService#deleteAllData(java.lang.String)
     */
    @Override
    public void deleteAllData(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] idArr = ids.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < idArr.length; i++) {
                list.add(Integer.parseInt(idArr[i]));
            }
            brandDao.deleteAllData(list);
        }
    }

    /* (non-Javadoc)
     * @see com.fh.service.brand.IBrandService#initBrandList()
     */
    @Override
    public List<BrandInfo> initBrandList() {
        String brandList = JedisUtil.get("initBrandList");
        Gson gson = new Gson();
        if (StringUtils.isEmpty(brandList)) {
            List<BrandInfo> brandInfos = brandDao.initBrandList();
            String s = gson.toJson(brandInfos);
            JedisUtil.set("initBrandList", s);
            return brandInfos;
        } else {
            List<BrandInfo> brandInfos = gson.fromJson(brandList, new TypeToken<List<BrandInfo>>() {
            }.getType());
            return brandInfos;
        }
    }

}
