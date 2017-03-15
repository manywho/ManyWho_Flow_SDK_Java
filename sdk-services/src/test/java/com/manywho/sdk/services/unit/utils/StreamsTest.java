package com.manywho.sdk.services.unit.utils;

import com.google.common.collect.Lists;
import com.manywho.sdk.services.utils.Streams;
import org.junit.Test;

import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StreamsTest {
    @Test
    public void testAsStreamWithIterable() {
        Iterable<String> iterable = Lists.newArrayList(
                "abc",
                "def",
                "123",
                "456"
        );

        Stream<String> stream = Streams.asStream(iterable);

        assertNotNull(stream);
        assertEquals(4, stream.count());
    }

    @Test
    public void testAsStreamWithIterableParallel() {
        Iterable<String> iterable = Lists.newArrayList(
                "abc",
                "def",
                "123",
                "456"
        );

        Stream<String> stream = Streams.asStream(iterable, true);

        assertNotNull(stream);
        assertEquals(4, stream.count());
    }

    @Test
    public void testAsStreamWithIterator() {
        Iterator<String> iterator = Lists.newArrayList(
                "abc",
                "def",
                "123",
                "456"
        ).iterator();

        Stream<String> stream = Streams.asStream(iterator);

        assertNotNull(stream);
        assertEquals(4, stream.count());
    }

    @Test
    public void testAsStreamWithIteratorParallel() {
        Iterator<String> iterator = Lists.newArrayList(
                "abc",
                "def",
                "123",
                "456"
        ).iterator();

        Stream<String> stream = Streams.asStream(iterator, true);

        assertNotNull(stream);
        assertEquals(4, stream.count());
    }
}
