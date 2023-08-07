package com.lhj.designpatterns.proxy.securityProxy;

import java.util.Arrays;
import java.util.List;

/**
 * @author banyanmei
 */


public class UserAuthenticator {
    private final List<String> authorizedUserIds;

    public UserAuthenticator() {
        // 模拟从数据库或配置文件中获取已授权的用户列表
        authorizedUserIds = Arrays.asList("user1", "user2", "user3");
    }

    public boolean hasPermission(String userId) {
        return authorizedUserIds.contains(userId);
    }
}

