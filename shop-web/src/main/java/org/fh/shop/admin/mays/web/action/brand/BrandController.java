/**
 * <pre>项目名称:lalal
 * 文件名称:BrandController.java
 * 包名:com.fh.controller.brand
 * 创建日期:2019年1月27日下午7:12:48
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre>
 */
package org.fh.shop.admin.mays.web.action.brand;


import org.fh.shop.admin.mays.annontation.Log;
import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.model.brand.BrandInfo;
import org.fh.shop.admin.mays.service.brand.IBrandService;
import org.fh.shop.admin.mays.staticFinal.SystemStauts;
import org.fh.shop.admin.mays.util.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * <pre>项目名称：lalal
 * 类名称：BrandController
 *
 * 类描述：
 * 创建人：马优生 178249290@qq.com
 * 创建时间：2019年1月27日 下午7:12:48
 * 修改人：马优生 178249290@qq.com
 * 修改时间：2019年1月27日 下午7:12:48
 * 修改备注：
 * @version </pre>
 */
@Controller
@RequestMapping("/brand/")
public class BrandController {
    @Resource
    private IBrandService brandService;

    @RequestMapping("toBrandList")
    public String toBrandList() {
        return "brand/brandList";
    }


    /**
     * 下拉框
     *
     * @return
     */
    @RequestMapping("findList")
    public ServiceResponse findList() {
        List<BrandInfo> list = brandService.initBrandList();
        return ServiceResponse.success(list);
    }


    /**
     * <pre>findBrandList(条件分页查询)
     * 创建人：马优生 178249290@qq.com
     * 创建时间：2019年1月27日 下午7:17:06
     * 修改人：马优生 178249290@qq.com
     * 修改时间：2019年1月27日 下午7:17:06
     * 修改备注：
     * @return</pre>
     */
    @RequestMapping("findBrandList")
    @ResponseBody
    public Map findBrandList(BrandInfo brandInfo) {
        Long count = brandService.countListSize(brandInfo);
        List<BrandInfo> list = brandService.findBrandList(brandInfo);
        Map hashMap = new HashMap();
        hashMap.put("draw", brandInfo.getDraw());
        hashMap.put("recordsTotal", list.size());
        hashMap.put("recordsFiltered", count);
        hashMap.put("data", list);
        return hashMap;
    }

    /**
     * <pre>addBrand(添加)
     * 创建人：马优生 178249290@qq.com
     * 创建时间：2019年1月27日 下午7:48:59
     * 修改人：马优生 178249290@qq.com
     * 修改时间：2019年1月27日 下午7:48:59
     * 修改备注：
     * @param brandInfo
     * @return</pre>
     */
    @RequestMapping("addBrand")
    @ResponseBody
    @Log("添加brand数据")
    public ServiceResponse addBrand(BrandInfo brandInfo) {
        brandService.addBrand(brandInfo);
        CacheManager.getInstance().remove(SystemStauts.BRANDLIST);
        return ServiceResponse.success();
    }

    /**
     * <pre>updateBrand(修改)
     * 创建人：马优生 178249290@qq.com
     * 创建时间：2019年1月27日 下午7:50:39
     * 修改人：马优生 178249290@qq.com
     * 修改时间：2019年1月27日 下午7:50:39
     * 修改备注：
     * @return</pre>
     */
    @RequestMapping("updateBrand")
    @ResponseBody
    @Log("修改brand数据")
    public ServiceResponse updateBrand(BrandInfo brandInfo) {
        brandService.updateBrand(brandInfo);
        CacheManager.getInstance().remove(SystemStauts.BRANDLIST);
        return ServiceResponse.success();
    }

    /**
     * <pre>deleteAllData(删除)
     * 创建人：马优生 178249290@qq.com
     * 创建时间：2019年1月27日 下午7:56:02
     * 修改人：马优生 178249290@qq.com
     * 修改时间：2019年1月27日 下午7:56:02
     * 修改备注：
     * @param ids
     * @return</pre>
     */
    @RequestMapping("deleteAllData")
    @ResponseBody
    @Log("删除brand数据")
    public ServiceResponse deleteAllData(String ids) {
        brandService.deleteAllData(ids);
        CacheManager.getInstance().remove(SystemStauts.BRANDLIST);
        return ServiceResponse.success();
    }

    /**
     * <pre>initBrandList(下拉框)
     * 创建人：马优生 178249290@qq.com
     * 创建时间：2019年1月28日 下午8:27:17
     * 修改人：马优生 178249290@qq.com
     * 修改时间：2019年1月28日 下午8:27:17
     * 修改备注：
     * @return</pre>
     */
    @RequestMapping("initBrandList")
    @ResponseBody
    public ServiceResponse initBrandList() {
        List<BrandInfo> list = (List<BrandInfo>) CacheManager.getInstance().getObj(SystemStauts.BRANDLIST);
        if (list != null) {
            return ServiceResponse.success(list);
        }
        list = brandService.initBrandList();
        CacheManager.getInstance().putObj(SystemStauts.BRANDLIST, list);
        return ServiceResponse.success(list);
    }

    /**
     * 文件上传
     *
     * @param request
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("springUpload")
    @ResponseBody
    public ServiceResponse springUpload(HttpServletRequest request)
            throws IllegalStateException, IOException {
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        String loadPath = "";
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //file.getOriginalFilename() 获取文件的文件名
                    String originalFilename = file.getOriginalFilename();
                    //对文件进行重命名
                    String randomUUIDFilename = UUID.randomUUID().toString() + originalFilename.substring(file.getOriginalFilename().lastIndexOf("."));
                    //获取项目在磁盘上的根目录下的upload文件夹路径
                    String path = request.getServletContext().getRealPath("/upload") + "/" + randomUUIDFilename;
                    //上传
                    //springmvc封装的方法，用于文件上传时，把内存中文件写入磁盘
                    file.transferTo(new File(path));
                    loadPath = "/upload" + "/" + randomUUIDFilename;
                }
            }
        }
        return ServiceResponse.success(loadPath);
    }
}
