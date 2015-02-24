/*
 * Written by Jaroslav Tulach, and released to the public domain,
 * as explained at http://creativecommons.org/publicdomain/zero/1.0/
 */
package org.ObjectLayout;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

final class Field {
    private final java.lang.reflect.Field delegate;

    public Field(java.lang.reflect.Field delegate) {
        this.delegate = delegate;
    }
    
    static Field[] declaredFields(Class<?> clazz) {
        final java.lang.reflect.Field[] arr = clazz.getDeclaredFields();
        Field[] ret = new Field[arr.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = new Field(arr[i]);
        }
        return ret;
    }
    
    Object get(Object thiz) throws IllegalAccessException {
        return delegate.get(thiz);
    }
    
    void set(Object thiz, Object v) throws IllegalAccessException {
        delegate.set(thiz, v);
    }

    int getModifiers() {
        return delegate.getModifiers();
    }

    void setAccessible(boolean b) {
        delegate.setAccessible(b);
    }

    String getName() {
        return delegate.getName();
    }

    Class<?> getType() {
        return delegate.getType();
    }

    Type getGenericType() {
        return delegate.getGenericType();
    }

    Class<?> getDeclaringClass() {
        return delegate.getDeclaringClass();
    }

    <T extends Annotation> T getAnnotation(Class<T> anno) {
        return delegate.getAnnotation(anno);
    }
}
