package com.xian.reflect;

import com.xian.test.Person;

public class ReflectDemo01 {
    public static void main(String[] args) {

        try {
            //1.获取Class.forName("全类名")    #（含包名）
            Class cls = Class.forName("com.xian.test.Person");
            System.out.println(cls);
            //2.类名.class
            Class cls2 = Person.class;
            System.out.println(cls2);
            //3.对象.getClass()
            Person person = new Person();
            Class cls3 = person.getClass();
            System.out.println(cls3);

            //==比较三个class对象是否为同一个
            System.out.println(cls==cls2);
            System.out.println(cls==cls3);
            System.out.println(cls2==cls3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
