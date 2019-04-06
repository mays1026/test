package org.fh.shop.admin.mays.service.area;

import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.model.area.AreaInfo;

import java.util.List;

public interface IAreaService {
    List<AreaInfo> initAreaList();

    ServiceResponse addAreaInfo(AreaInfo areaInfo);

    ServiceResponse deleteAreaById(Integer id);

    ServiceResponse updateAreaData(AreaInfo areaInfo);
}
