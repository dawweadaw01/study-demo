package com.lhj.dynamicdatasource.mapper.master;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhj.dynamicdatasource.entity.Test;
import org.springframework.stereotype.Component;

@Component("testMapper1")
public interface TestMapper extends BaseMapper<Test> {
}
