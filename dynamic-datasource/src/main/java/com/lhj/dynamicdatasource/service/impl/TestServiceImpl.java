package com.lhj.dynamicdatasource.service.impl;

import com.lhj.dynamicdatasource.config.DynamicDataSource;
import com.lhj.dynamicdatasource.entity.Test;
import com.lhj.dynamicdatasource.mapper.TestMapper;
import com.lhj.dynamicdatasource.service.TestService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author banyanmei
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private com.lhj.dynamicdatasource.mapper.master.TestMapper testMapper1;
    @Resource
    private com.lhj.dynamicdatasource.mapper.slave.TestMapper testMapper2;

    @Resource
    private TestMapper testMapper;

    @Override
    public Test getTestById(Integer id) {
        //根据id查询
        //System.out.println(testMapper1.selectById(id));
        //System.out.println(testMapper2.selectById(id));
        System.out.println(testMapper.selectById(2));
        DynamicDataSource.setName("slave");
        return testMapper1.selectById(id);
    }
}