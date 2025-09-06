package com.senn.mockumentum.test;

import com.senn.mockumentum.Mockumentum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ExampleServiceTest {

    private final Mockumentum mockumentum = new Mockumentum();
    private final ExampleService underTest = new ExampleService();

    @Test
    void testGetUid() {
        assertFalse(underTest.calculateUidForObject(null).contains("_"));


        String uid = underTest.calculateUidForObject();
    }

}
