package com.lhj.designpatterns.proxy.remoteProxy;

public class RemoteServiceProxy implements RemoteService {
    private final String remoteServiceUrl;
    private final RemoteServiceImpl remoteService;

    public RemoteServiceProxy(String remoteServiceUrl, RemoteServiceImpl remoteService) {
        this.remoteServiceUrl = remoteServiceUrl;
        this.remoteService = new RemoteServiceImpl();
    }

    @Override
    public String fetchData(String dataId) {
        // 网络通信、序列化和反序列化等逻辑
        System.out.println("Connecting to remote service at: " + remoteServiceUrl);
        // 假设我们已经获取到远程服务的数据
        String result = remoteService.fetchData(dataId);
        System.out.println("Received data from remote service.");
        return result;
    }
}

