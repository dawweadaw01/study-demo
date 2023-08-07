package com.lhj.designpatterns.proxy.cacheProxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCacheProxy {
    @Test
    public void test() {
        CachingDataQueryProxy cachingDataQueryProxy = new CachingDataQueryProxy();
        String query = cachingDataQueryProxy.query("queryKey");
        System.out.println(query);
        String query1 = cachingDataQueryProxy.query("queryKey");
        System.out.println(query1);
    }
}
