/**
 * <pre>项目名称:lalal
 * 文件名称:ProductContorller.java
 * 包名:com.fh.controller.shop.product
 * 创建日期:2019年1月27日下午2:12:37
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre>
 */
package org.fh.shop.admin.mays.web.action.product;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.fh.shop.admin.mays.annontation.Log;
import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.model.brand.BrandInfo;
import org.fh.shop.admin.mays.model.images.ImagesInfo;
import org.fh.shop.admin.mays.model.product.ProductInfo;
import org.fh.shop.admin.mays.service.brand.IBrandService;
import org.fh.shop.admin.mays.service.product.IImagesService;
import org.fh.shop.admin.mays.service.product.IProductService;
import org.fh.shop.admin.mays.util.FileUtil;
import org.fh.shop.admin.mays.util.QQCOSUtil;
import org.fh.shop.admin.mays.web.action.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <pre>项目名称：lalal
 * 类名称：ProductContorller
 * 类描述：
 * 创建人：马优生 178249290@qq.com
 * 创建时间：2019年1月27日 下午2:12:37
 * 修改人：马优生 178249290@qq.com
 * 修改时间：2019年1月27日 下午2:12:37
 * 修改备注：
 * @version </pre>
 */
@Controller
@RequestMapping("/product/")
public class ProductContorller extends BaseController {

    @Resource
    private IProductService prodoctService;
    @Resource
    private IBrandService brandService;
    @Resource
    private IImagesService imagesService;

    @RequestMapping("toproductList")
    public String toproductList() {
        return "product/productList";
    }


    /**
     * 查询图片
     *
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("findImagesList")
    public String findImagesList(Integer id, ModelMap map) {
        List<ImagesInfo> list = imagesService.findImagesList(id);
        map.put("list", list);
        return "images/imagesList";
    }

    @RequestMapping("deleteProduct")
    @ResponseBody
    public void deleteProduct(Integer id) {
        prodoctService.deleteProduct(id);
    }

    /**
     * ajax
     *
     * @param productInfo
     * @return
     */
    @RequestMapping("ajaxFindProductList")
    @ResponseBody
    public Map<String, Object> ajaxFindProductList(ProductInfo productInfo, HttpServletRequest requset) {
        String dir = requset.getParameter("order[0][dir]");
        String column = requset.getParameter("order[0][column]");
        if (StringUtils.isNotEmpty(column)) {
            int i = Integer.parseInt(column) - 1;
            productInfo.setFiled(i + "");
            productInfo.setOrderby(dir);
        }
        Long count = prodoctService.countListSize(productInfo);
        List<ProductInfo> list = prodoctService.findProductList(productInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("draw", productInfo.getDraw());
        map.put("recordsTotal", list.size());
        map.put("recordsFiltered", count);
        map.put("data", list);
        return map;
    }

    /**
     * <pre>addProduct(新增)
     * 创建人：马优生 178249290@qq.com
     * 创建时间：2019年1月27日 下午9:02:02
     * 修改人：马优生 178249290@qq.com
     * 修改时间：2019年1月27日 下午9:02:02
     * 修改备注：
     * @param productInfo
     * @return</pre>
     */
    @RequestMapping("addProduct")
    @Log("添加product数据")
    public String addProduct(ProductInfo productInfo, String imgPath) {
        //插入product数据
        prodoctService.addProduct(productInfo, imgPath);
        return "redirect:/product/toproductList.action";
    }

    /**
     * <pre>updateProduct(修改)
     * 创建人：马优生 178249290@qq.com
     * 创建时间：2019年1月27日 下午9:03:00
     * 修改人：马优生 178249290@qq.com
     * 修改时间：2019年1月27日 下午9:03:00
     * 修改备注：
     * @return</pre>
     */
    @RequestMapping("updateProduct")
    @Log("修改product数据")
    public String updateProduct(ProductInfo productInfo, ImagesInfo imagesInfo) {
        //更新product
        prodoctService.updateProduct(productInfo, imagesInfo);
        return "redirect:/product/toproductList.action";
    }

    /**
     * 跳转添加页面
     *
     * @return
     */
    @RequestMapping("toAddProduct")
    public String toAddProduct() {
        return "product/addProduct";
    }

    /**
     * <pre>deleteAllData(刪除)
     * 创建人：马优生 178249290@qq.com
     * 创建时间：2019年1月27日 下午9:04:50
     * 修改人：马优生 178249290@qq.com
     * 修改时间：2019年1月27日 下午9:04:50
     * 修改备注：
     * @return</pre>
     */
    @RequestMapping("deleteAllData")
    @ResponseBody
    @Log("删除product数据")
    public ServiceResponse deleteAllData(String ids) {
        prodoctService.deleteAllData(ids);
        return ServiceResponse.success();
    }

    /**
     * <pre>updateProduct(回显)
     * 创建人：马优生 178249290@qq.com
     * 创建时间：2019年1月28日 下午9:51:12
     * 修改人：马优生 178249290@qq.com
     * 修改时间：2019年1月28日 下午9:51:12
     * 修改备注：
     * @return</pre>
     */
    @RequestMapping("toupdateProduct")
    public String toupdateProduct(ModelMap map, Integer id) {
        ProductInfo productInfo = prodoctService.toupdateProduct(id);
        map.put("productInfo", productInfo);
        return "product/updateProduct";
    }

    /**
     * 导出数据
     */
    @RequestMapping("exportData")
    public void exportData(ProductInfo productInfo, HttpServletResponse response) {
        List<ProductInfo> exportList = prodoctService.findExportData(productInfo);
        //创建workbook工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("测试");
        XSSFRow titleRow = sheet.createRow(0);
        XSSFCell titleRowCell = titleRow.createCell(0);
        titleRowCell.setCellValue("产品名称");
        for (int i = 0; i < exportList.size(); i++) {
            ProductInfo product = exportList.get(i);
            XSSFRow row = sheet.createRow(i + 1);
            XSSFCell cell = row.createCell(0);
            cell.setCellValue(product.getProductName());
        }
        FileUtil.excelDownload(workbook, response);
    }

    /**
     * 按品牌导出数据
     */
    @RequestMapping("exportDataByBrand")
    public void exportDataByBrand(ProductInfo product, HttpServletResponse response) {

        //查询出所有品牌
        List<BrandInfo> brandList = brandService.initBrandList();
        //创建workbook
        XSSFWorkbook workbook = getWorkbook(product, brandList);
        FileUtil.excelDownload(workbook, response);
    }

    public XSSFWorkbook getWorkbook(ProductInfo product, List<BrandInfo> brandList) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        //时间样式
        XSSFCellStyle dateStyle = getCellStyle(workbook, "yyyy-MM-dd HH:mm:ss");

        //double格式
        XSSFCellStyle doubleStyle = getCellStyle(workbook, "0.0");
        //表头样式
        XSSFCellStyle titleStyle = workbook.createCellStyle();
        //创建字体样式
        XSSFFont font = getXssfFontStyle(workbook);
        //调整表头样式
        changeTitleStyle(titleStyle, font);
        Integer brandId = product.getBrandId().getId();
        for (int i = 0; i < brandList.size(); i++) {
            BrandInfo brandInfo = brandList.get(i);
            //按品牌查询商品
            List<ProductInfo> productList = new ArrayList<>();
            if (brandId == -1) {
                product.getBrandId().setId(brandInfo.getId());
                productList = prodoctService.findExportByBrandData(product);
            } else {
                if (brandId == brandInfo.getId()) {
                    product.getBrandId().setId(brandInfo.getId());
                    productList = prodoctService.findExportByBrandData(product);
                }
            }
            XSSFSheet sheet = workbook.createSheet(brandInfo.getBrandName() + "【" + productList.size() + "】");
            //合并单元格
            CellRangeAddress rangeAddress = new CellRangeAddress(2, 4, 7, 11);
            sheet.addMergedRegion(rangeAddress);
            //表头
            XSSFRow row2 = sheet.createRow(2);
            XSSFCell cell6 = row2.createCell(7);
            cell6.setCellValue("商品列表");
            cell6.setCellStyle(titleStyle);

            //创建表头
            buildTitleRow(sheet);
            //创建数据
            if (productList.size() != 0) {
                buildTableData(workbook, dateStyle, doubleStyle, productList, sheet);
            }
        }
        return workbook;
    }

    public void changeTitleStyle(XSSFCellStyle titleStyle, XSSFFont font) {
        titleStyle.setFont(font);
        titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        titleStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    }

    public XSSFFont getXssfFontStyle(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeight(26);
        font.setColor(XSSFFont.COLOR_RED);
        return font;
    }

    public XSSFCellStyle getCellStyle(XSSFWorkbook workbook, String pattern) {
        XSSFCellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(workbook.createDataFormat().getFormat(pattern));
        return dateStyle;
    }

    public void buildTableData(XSSFWorkbook workbook, XSSFCellStyle dateStyle, XSSFCellStyle doubleStyle, List<ProductInfo> productList, XSSFSheet sheet) {
        for (int j = 0; j < productList.size(); j++) {
            ProductInfo productInfo = productList.get(j);
            XSSFRow row1 = sheet.createRow(j + 6);
            XSSFCell cell3 = row1.createCell(7);
            cell3.setCellValue(productInfo.getProductName());
            XSSFCell cell4 = row1.createCell(8);
            cell4.setCellValue(productInfo.getBrandId().getBrandName());
            XSSFCell cell5 = row1.createCell(9);
            cell5.setCellValue(productInfo.getMarketPrice());
            cell5.setCellStyle(doubleStyle);
            XSSFCell cellCreateTime = row1.createCell(10);
            cellCreateTime.setCellStyle(dateStyle);
            cellCreateTime.setCellValue(productInfo.getCreateTime());
            XSSFCell cellUpdateTime = row1.createCell(11);
            cellUpdateTime.setCellStyle(dateStyle);
            cellUpdateTime.setCellValue(productInfo.getUpdateTime());
            if (productInfo.getMarketPrice() < 100) {
                XSSFCellStyle cellPriceStyleCopy = workbook.createCellStyle();
                cellPriceStyleCopy.cloneStyleFrom(cell5.getCellStyle());
                cellPriceStyleCopy.setFillForegroundColor(HSSFColor.RED.index);
                cellPriceStyleCopy.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);


                XSSFCellStyle cellStyleCopy = workbook.createCellStyle();
                cellStyleCopy.cloneStyleFrom(cellCreateTime.getCellStyle());
                cellStyleCopy.setFillForegroundColor(HSSFColor.RED.index);
                cellStyleCopy.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);


                cell3.setCellStyle(cellPriceStyleCopy);
                cell4.setCellStyle(cellPriceStyleCopy);
                cell5.setCellStyle(cellPriceStyleCopy);
                cellCreateTime.setCellStyle(cellStyleCopy);
                cellUpdateTime.setCellStyle(cellStyleCopy);
            }
        }
    }

    public void buildTitleRow(XSSFSheet sheet) {
        //第一行
        XSSFRow row = sheet.createRow(5);
        XSSFCell cell = row.createCell(7);
        cell.setCellValue("产品名称");
        XSSFCell cell1 = row.createCell(8);
        cell1.setCellValue("品牌名称");
        XSSFCell cell2 = row.createCell(9);
        cell2.setCellValue("价格");
        XSSFCell cell7 = row.createCell(10);
        cell7.setCellValue("录入时间");
        XSSFCell cell8 = row.createCell(11);
        cell8.setCellValue("修改时间");
    }

    /**
     * fileinput文件上传
     */
    @RequestMapping("fileInput")
    @ResponseBody
    public ServiceResponse fileInput(MultipartFile uploadFile) {
        String originalFilename = uploadFile.getOriginalFilename();
        //MultipartFile格式文件转换为File格式文件
        CommonsMultipartFile cf= (CommonsMultipartFile)uploadFile;
        DiskFileItem fi = (DiskFileItem)cf.getFileItem();
        File storeLocation = fi.getStoreLocation();
        System.out.println(storeLocation.getName());
        String s = QQCOSUtil.uploadFile(storeLocation, originalFilename);
        return ServiceResponse.success(s);
    }

}
