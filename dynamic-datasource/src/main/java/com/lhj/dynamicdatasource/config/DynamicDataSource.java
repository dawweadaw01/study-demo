package com.lhj.dynamicdatasource.config;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Component
@Primary
public class DynamicDataSource implements DataSource, InitializingBean {

    private static final ThreadLocal<String> NAME = new ThreadLocal<>();

    @Resource(name = "masterDataSource")
    private DataSource masterDataSource;
    @Resource(name = "slaveDataSource")
    private DataSource slaveDataSource;

    @Override
    public Connection getConnection() throws SQLException {
        if (NAME.get() == null || "master".equals(NAME.get())) {
            NAME.set("master");
            return masterDataSource.getConnection();
        } else if ("slave".equals(NAME.get())) {
            NAME.set("slave");
            return slaveDataSource.getConnection();
        } else {
            return masterDataSource.getConnection();
        }
    }

    public static void setName(String name) {
        NAME.set(name);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
