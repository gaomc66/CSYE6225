package com.mengchen.assignment2.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public  static boolean passwordPatternCorrect(String password) {
        Pattern p = Pattern.compile("(?=^.{8,30}$)((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))^.*");
        Matcher m = p.matcher(password);
        boolean result = m.matches();
        System.out.println("Password Pattern: " + result);
        return result;
    }
}
