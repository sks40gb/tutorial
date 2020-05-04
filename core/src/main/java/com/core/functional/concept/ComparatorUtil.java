package com.core.functional.concept;

import com.core.functional.concept.ToIntFunction;

import java.io.Serializable;
import java.util.*;

public interface ComparatorUtil<T> {

    public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
            (c1, c2) -> Integer.compare(keyExtractor.applyAsInt(c1), keyExtractor.applyAsInt(c2));
    }
}
