package com.bornander.utils;

public class Log {

    private Log() {
    }

    public static void i(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

    public static void e(String format, Object... args) {
        System.err.println(String.format(format, args));
    }
}
