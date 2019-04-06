package org.fh.shop.admin.mays.service.area;

import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.dao.area.IAreaDao;
import org.fh.shop.admin.mays.model.area.AreaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名: IAreaServiceImpl
 * 描述：
 *
 * @author
 * @create 2019-03-12 21:46
 **/
@Service
public class IAreaServiceImpl implements IAreaService {

    @Autowired
    private IAreaDao areaDao;

    @Override
    public List<AreaInfo> initAreaList() {
        return areaDao.initAreaList();
    }

    @Override
    public ServiceResponse addAreaInfo(AreaInfo areaInfo) {
        areaDao.addAreaInfo(areaInfo);
        return ServiceResponse.success(areaInfo.getId());
    }

    @Override
    public ServiceResponse deleteAreaById(Integer id) {
        areaDao.deleteAreaById(id);
        return ServiceResponse.success();
    }

    @Override
    public ServiceResponse updateAreaData(AreaInfo areaInfo) {
        areaDao.updateAreaData(areaInfo);
        return ServiceResponse.success();
    }
}
