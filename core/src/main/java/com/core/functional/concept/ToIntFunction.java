package com.core.functional.concept;

@FunctionalInterface
public interface ToIntFunction<T> {
    int applyAsInt(T t);
}
