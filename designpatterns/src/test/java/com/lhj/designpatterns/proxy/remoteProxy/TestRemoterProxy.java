package com.lhj.designpatterns.proxy.remoteProxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(org.springframework.test.context.junit4.SpringRunner.class)
public class TestRemoterProxy {
    @Test
    public void test() {
        RemoteServiceProxy remoteServiceProxy = new RemoteServiceProxy("https://example.com/remote-service", new RemoteServiceImpl());
        String fetchData = remoteServiceProxy.fetchData("dataId");
        System.out.println(fetchData);
    }
    
}
