package org.fh.shop.admin.mays.service.dept;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.model.po.dept.DeptInfo;

import java.util.List;

public interface IDeptService {
    Long countDeptList(DeptInfo deptInfo);

    List<DeptInfo> findDeptList(DeptInfo deptInfo);

    List<DeptInfo> initDeptList();

    void addDeptInfo(DeptInfo deptInfo);

    ServiceResponse deleteDeptInfo(List<Integer> ids);

    void updateDeptInfo(DeptInfo deptInfo);

    XSSFWorkbook exportExcelWhereDept(Integer deptId);
}
