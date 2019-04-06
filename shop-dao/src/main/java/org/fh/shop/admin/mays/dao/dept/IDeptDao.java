package org.fh.shop.admin.mays.dao.dept;

import org.fh.shop.admin.mays.model.po.dept.DeptInfo;

import java.util.List;

public interface IDeptDao {


    Long countDeptList(DeptInfo deptInfo);

    List<DeptInfo> findDeptList(DeptInfo deptInfo);

    List<DeptInfo> initDeptList();

    void addDeptInfo(DeptInfo deptInfo);

    void deleteDeptInfo(List<Integer> list);

    void updateDeptInfo(DeptInfo deptInfo);

    List<DeptInfo> findDeptChidenWhereId(Integer deptId);
}
