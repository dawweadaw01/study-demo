package com.lhj.designpatterns.proxy.cacheProxy;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CachingDataQueryProxy implements DataQuery {

    private DataQuery dataQuery;

    //cache
    private Map<String, String> cache = new HashMap<>(256);

    public CachingDataQueryProxy() {
        this.dataQuery = new DatabaseDataQuery();
    }


    @Override
    public String query(String queryKey) {

        if (cache.get(queryKey) != null) {
            log.info("query from cache");
            return cache.get(queryKey);
        } else {
            String query = dataQuery.query(queryKey);
            cache.put(queryKey, query);
            log.info("query from database and put into cache");
            return query;
        }
    }
}
