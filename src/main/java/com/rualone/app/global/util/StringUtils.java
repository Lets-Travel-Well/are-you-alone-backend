package com.rualone.app.global.util;

public class StringUtils {
    public static String customTrim(String input){
        return input.replaceAll("(\r\n|\r|\n|\n\r)", "");
    }
}
