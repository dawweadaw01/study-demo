package com.lhj.designpatterns.proxy.securityProxy;

/**
 * @author banyanmei
 */
public class SensitiveDataQueryImpl implements SensitiveDataQuery {

    @Override
    public String queryData(String userId) {
        // 查询敏感数据并返回结果
        return "Sensitive data for user: " + userId;
    }
}

