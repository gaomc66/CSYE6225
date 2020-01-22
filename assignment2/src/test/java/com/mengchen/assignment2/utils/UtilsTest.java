package com.mengchen.assignment2.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void passwordPatternCorrect() {

        String password = "Delete123!";
        assertEquals(Utils.passwordPatternCorrect("Delete123!"), true);
    }
}