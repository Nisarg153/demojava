package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testGreet() {
        App app = new App();
        String result = app.greet("Maven");
        assertEquals("Hello, Maven!", result);
    }
}
