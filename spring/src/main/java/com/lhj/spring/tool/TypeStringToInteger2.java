package com.lhj.spring.tool;

import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;

/**
 * @description：
 * @createTime：2023-10-0415:23
 * @author：banyanmei
 */
public class TypeStringToInteger2 implements Converter<TypedStringValue, Integer> {
    @Override
    public Integer convert(TypedStringValue source) {
        return Integer.valueOf(Objects.requireNonNull(source.getValue()));
    }
}
