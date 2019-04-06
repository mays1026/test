package org.fh.shop.admin.mays.dao.area;

import org.fh.shop.admin.mays.model.area.AreaInfo;

import java.util.List;

public interface IAreaDao {
    List<AreaInfo> initAreaList();

    void addAreaInfo(AreaInfo areaInfo);

    void deleteAreaById(Integer id);

    void updateAreaData(AreaInfo areaInfo);
}
