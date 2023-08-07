package com.lhj.designpatterns.proxy.securityProxy;


/**
 * @author banyanmei
 */
public class SecurityProxy implements SensitiveDataQuery {
    private final SensitiveDataQuery sensitiveDataQuery;
    private final UserAuthenticator userAuthenticator;

    public SecurityProxy(SensitiveDataQuery sensitiveDataQuery, UserAuthenticator userAuthenticator) {
        this.sensitiveDataQuery = sensitiveDataQuery;
        this.userAuthenticator = userAuthenticator;
    }

    @Override
    public String queryData(String userId) {
        if (userAuthenticator.hasPermission(userId)) {
            return sensitiveDataQuery.queryData(userId);
        } else {
            return "Access Denied: Insufficient permission for user" + userId;
        }
    }
}

