package com.manywho.sdk.utils;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtils {
    public static <T> Stream<T> asStream(Iterable<T> iterable) {
        return asStream(iterable.iterator());
    }

    public static <T> Stream<T> asStream(Iterable<T> iterable, boolean parallel) {
        return asStream(iterable.iterator(), true);
    }

    public static <T> Stream<T> asStream(Iterator<T> iterator) {
        return asStream(iterator, false);
    }

    public static <T> Stream<T> asStream(Iterator<T> iterator, boolean parallel) {
        Iterable<T> iterable = () -> iterator;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }
}
