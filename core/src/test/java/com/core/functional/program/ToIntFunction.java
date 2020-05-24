package com.core.functional.program;

@FunctionalInterface
public interface ToIntFunction<T> {
    int applyAsInt(T t);
}
