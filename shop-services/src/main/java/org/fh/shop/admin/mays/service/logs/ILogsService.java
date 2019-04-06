package org.fh.shop.admin.mays.service.logs;

import org.fh.shop.admin.mays.model.logs.LogsInfo;

import java.util.List;

public interface ILogsService {
    void addLogs(LogsInfo logsInfo);

    List<LogsInfo> findLogsList(LogsInfo logsInfo);

    Long countListSize(LogsInfo logsInfo);
}
