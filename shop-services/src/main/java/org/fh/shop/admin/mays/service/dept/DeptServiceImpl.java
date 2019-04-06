package org.fh.shop.admin.mays.service.dept;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.dao.dept.IDeptDao;
import org.fh.shop.admin.mays.dao.user.IUserDao;
import org.fh.shop.admin.mays.model.po.dept.DeptInfo;
import org.fh.shop.admin.mays.model.po.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名: DeptServiceImpl
 * 描述：
 *
 * @author
 * @create 2019-03-03 14:28
 **/
@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDao deptDao;
    @Autowired
    private IUserDao userDao;

    @Override
    public Long countDeptList(DeptInfo deptInfo) {
        return deptDao.countDeptList(deptInfo);
    }

    @Override
    public List<DeptInfo> findDeptList(DeptInfo deptInfo) {
        return deptDao.findDeptList(deptInfo);
    }

    @Override
    public List<DeptInfo> initDeptList() {
        return deptDao.initDeptList();
    }

    @Override
    public void addDeptInfo(DeptInfo deptInfo) {
        deptDao.addDeptInfo(deptInfo);
    }

    @Override
    public ServiceResponse deleteDeptInfo(List<Integer> ids) {
        deptDao.deleteDeptInfo(ids);
        userDao.deleteUserInfoByDept(ids);
        return ServiceResponse.success();
    }

    @Override
    public void updateDeptInfo(DeptInfo deptInfo) {
        deptDao.updateDeptInfo(deptInfo);
    }

    public List<DeptInfo> findDeptChidenWhereId(Integer deptId) {
        List<DeptInfo> deptChidenWhereId = deptDao.findDeptChidenWhereId(deptId);
        if (!deptChidenWhereId.isEmpty()) {
            for (int i = 0; i < deptChidenWhereId.size(); i++) {
                DeptInfo deptInfo = deptChidenWhereId.get(i);
                findDeptChidenWhereId(deptInfo.getId());
            }
        }
        return deptChidenWhereId;
    }

    @Override
    public XSSFWorkbook exportExcelWhereDept(Integer deptId) {
        List<DeptInfo> deptChidenWhereId = findDeptChidenWhereId(deptId);
        XSSFWorkbook workbook = new XSSFWorkbook();
        for (int i = 0; i < deptChidenWhereId.size(); i++) {
            DeptInfo deptInfo = deptChidenWhereId.get(i);
            XSSFSheet sheet = workbook.createSheet(deptInfo.getIndustryTitle());
            List<UserInfo> userInfoList = userDao.findUserChidenWhereId(deptInfo.getId());
            for (int j = 0; j < userInfoList.size(); j++) {
                UserInfo userInfo = userInfoList.get(j);
                XSSFRow row = sheet.createRow(0);
                XSSFCell cell1 = row.createCell(0);
                cell1.setCellValue(userInfo.getUserName());
                XSSFCell cell2 = row.createCell(1);
                cell2.setCellValue(userInfo.getUserRealName());
            }

        }
        return workbook;
    }
}
