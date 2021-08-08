package com.xian.Annotation;

import com.xian.Annotation.Check;

public class Caculator {
    /**
     * ¼Ó
     * @param num1
     * @param num2
     * @return
     */
    public void add(int num1,int num2){
        num1 = 10;
        num2 = 14;
        System.out.println(num1+num2); ;
    }
    @Check
    public void sub(){
        int num1 = 10;
        int num2 = 7;
        System.out.println(num1-num2);
    }
    @Check
    public void div(){
        System.out.println("1/0="+(1/0));
    }
}
