package com.github.darthwotan.Profile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {
    @Test
    void hasCorrectData(){
        SaveProfiles saveProfiles = new SaveProfiles();
        Profile classUnderTest = new Profile("Testname","Test", "Teststraße 19", 34, "1234", saveProfiles);
        assertEquals("Testname", classUnderTest.getName());
        assertEquals("Test", classUnderTest.getUsername());
        assertEquals("Teststraße 19", classUnderTest.getAddress());
        assertEquals(34, classUnderTest.getAge());
        assertEquals("1234", classUnderTest.getPassword());

    }
}
