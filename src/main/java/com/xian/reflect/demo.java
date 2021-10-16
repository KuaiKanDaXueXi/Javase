package com.xian.reflect;

import java.util.Locale;

public class demo {
    public static void main(String[] args) {
        String s = "zhangsan";
        String s1 = "get" + (s.charAt(0)+"").toUpperCase(Locale.ROOT)+s.substring(1);
        System.out.println(s1);
    }
}
