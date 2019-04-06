package org.fh.shop.admin.mays.service.logs;

import org.fh.shop.admin.mays.dao.logs.LogsDao;
import org.fh.shop.admin.mays.model.logs.LogsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsServiceImpl implements ILogsService {

    @Autowired
    private LogsDao logsDao;

    @Override
    public void addLogs(LogsInfo logsInfo) {
        logsDao.addLogs(logsInfo);
    }

    @Override
    public List<LogsInfo> findLogsList(LogsInfo logsInfo) {
        return logsDao.findLogsList(logsInfo);
    }

    @Override
    public Long countListSize(LogsInfo logsInfo) {
        return logsDao.countListSize(logsInfo);
    }
}
