package com.lhj.dynamicdatasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhj.dynamicdatasource.entity.Test;
import org.springframework.stereotype.Component;

@Component("testMapper3")
public interface TestMapper extends BaseMapper<Test> {
}
