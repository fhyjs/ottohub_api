package org.eu.hanana.reimu.lib.ottohub.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ClassUtil {
    @SuppressWarnings("unchecked")
    public static <T extends Object> Class<T> getActualTClass(Object instance) {
        Type genericSuper = instance.getClass().getGenericSuperclass();
        if (!(genericSuper instanceof ParameterizedType pt)) {
            throw new RuntimeException("必须使用子类固化泛型，不能直接new DataWrapResult<T>");
        }
        Type[] actualTypes = pt.getActualTypeArguments();
        if (actualTypes.length == 0) {
            throw new RuntimeException("未找到泛型参数T");
        }
        Type type = actualTypes[0];
        if (!(type instanceof Class<?> clazz)) {
            throw new RuntimeException("T不是普通Class，不支持嵌套泛型");
        }
        return (Class<T>) clazz;
    }

}
