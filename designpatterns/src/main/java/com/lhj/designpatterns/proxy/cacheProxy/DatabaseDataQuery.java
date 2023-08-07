package com.lhj.designpatterns.proxy.cacheProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author banyanmei
 */

@Slf4j
public class DatabaseDataQuery implements DataQuery {
    @Override
    public String query(String queryKey) {
        log.info("query from database");
        return "query from database" + queryKey;
    }
}
