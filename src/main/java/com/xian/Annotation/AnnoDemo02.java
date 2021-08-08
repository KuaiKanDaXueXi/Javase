package com.xian.Annotation;

import java.util.Date;

/**
 * JDK中一些预定义的注解
 * * @Override ：检测被该注解标注的方法是否是继承自父类（接口）的
 * * @Deprecated ：将该注解标注的内容，表示已过时
 * * @SuppressWarnings ：压制警告的
 * @author Xian
 */
@SuppressWarnings("all")
@MyAnno3
public class AnnoDemo02 {
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1(){
        System.out.println("show");
    }
    public void show2(){
        System.out.println("show");
    }
    public void demo(){
        show1();
        Date date = new Date();
        date.getDate();
    }

    public static void main(String[] args) {
        AnnoDemo02 ad2 = new AnnoDemo02();
        ad2.show2();
    }
}
