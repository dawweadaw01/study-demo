package com.lhj.designpatterns.proxy.securityProxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(org.springframework.test.context.junit4.SpringRunner.class)
public class TwoSecurityProxy {
    @Test
    public void test() {
        SecurityProxy securityProxy = new SecurityProxy(new SensitiveDataQueryImpl(), new UserAuthenticator());
        String queryData = securityProxy.queryData("userId");
        System.out.println(queryData);
        System.out.println(securityProxy.queryData("user1"));
    }
}
