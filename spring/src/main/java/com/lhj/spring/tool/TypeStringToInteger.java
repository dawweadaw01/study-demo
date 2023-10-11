package com.lhj.spring.tool;

import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * @description：
 * @createTime：2023-10-0415:23
 * @author：banyanmei
 */
public class TypeStringToInteger implements GenericConverter {
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(TypedStringValue.class, Integer.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        TypedStringValue source1 = (TypedStringValue) source;
        return Integer.valueOf(Objects.requireNonNull(source1.getValue()));
    }
}
