package org.spring.app.utility;

import org.modelmapper.ModelMapper;

import java.util.List;

public class Mapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();
    private Mapper() {
    }

    public static <T> T map(Object source, Class<T> targetClass) {
        return MODEL_MAPPER.map(source, targetClass);
    }

    public static <T> List<T> mapList(List<?> sourceList, Class<T> targetClass) {
        return sourceList.stream().map(element -> map(element, targetClass)).toList();
    }
}
