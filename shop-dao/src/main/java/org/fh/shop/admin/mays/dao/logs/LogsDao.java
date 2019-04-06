package org.fh.shop.admin.mays.dao.logs;

import org.fh.shop.admin.mays.model.logs.LogsInfo;

import java.util.List;

public interface LogsDao {
    void addLogs(LogsInfo logsInfo);

    List<LogsInfo> findLogsList(LogsInfo logsInfo);

    Long countListSize(LogsInfo logsInfo);
}
