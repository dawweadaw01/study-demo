package com.lhj.dynamicdatasource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author banyanmei
 */
@Data
@TableName("test")
public class Test {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;
}
