package com.example.helloworld;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {

    @Test
    public void testAddNumbers() {
        assertEquals(30, HelloWorld.addNumbers(10, 20));
        assertEquals(0, HelloWorld.addNumbers(0, 0));
        assertEquals(-5, HelloWorld.addNumbers(10, -15));
    }

    @Test
    public void testMainMethod() {
        // Just ensure it runs without exception
        assertDoesNotThrow(() -> HelloWorld.main(new String[]{}));
    }
}