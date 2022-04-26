package com.github.darthwotan.Profile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {
    @Test
    void hasCorrectData(){
        Profile classUnderTest = new Profile("Test", "Teststraße 19", 34, "1234");
        assertEquals("Test", classUnderTest.getName());
        assertEquals("Teststraße 19", classUnderTest.getAddress());
        assertEquals(34, classUnderTest.getAge());
        assertEquals("1234", classUnderTest.getPassword());

    }
}
