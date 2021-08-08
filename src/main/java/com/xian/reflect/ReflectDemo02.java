package com.xian.reflect;

import com.xian.test.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo02 {
    //0.获取Person的Class对象
    Class cls1 = Person.class;

    public void a(){
        /* 1. 获取成员变量们
        - Field[] getFields()                   //获取所有public修饰的成员变量
        - Field getField(String name)           //获取指定名称的public修饰的成员变量
        - Field[] getDeclaredFields()           //获取所有成员变量，不考虑修饰符
	    - Field getDeclaredField(String name)*/

        //1.获取成员变量
        Field[] fields = cls1.getFields();//获取所有public修饰的成员变量
        for (Field i:fields) {
            System.out.println(i);
        }
        System.out.println("------------------------------");
        try {
            //获取成员变量a的值
            Field a = cls1.getField("a");
            Person person = new Person();
            Object result = a.get(person);
            System.out.println(result);
            a.set(person,"zhangsan");
            System.out.println(person);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("------------------------------");
        try {
            Field[] declaredFields1 = cls1.getDeclaredFields();
            for (Field i:declaredFields1) {
                System.out.println(i);
            }

            //Field getDeclaredField(String name)
            Person person = new Person();
            Field declaredFielName = cls1.getDeclaredField("name");
            //忽略访问权限修饰的安全检查
            declaredFielName.setAccessible(true);//暴力反射
            Object o = declaredFielName.get(person);
            declaredFielName.set(person,"lisi");
            System.out.println(person);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(){
        /*2. 获取构造方法们
        - Constructor<?>[] getConstructors()
        - Constructor<?> getConstructor(类<?>...parameterTypes)
        - Constructor<?>[] getDeclaredConstructors()
        - Constructor<?> getDeclaredConstructor(类<?>...parameterTypes)*/

        //Constructor<?> getDeclaredConstructor(类<?>...parameterTypes)
        try {
            Constructor cst = cls1.getConstructor(String.class, Integer.class);
            System.out.println(cst);
            //创建对象
            Object person = cst.newInstance("张三",23);
            System.out.println(person);

            System.out.println("------------------------------");

            Constructor cst1 = cls1.getConstructor();
            Object person1 = cst1.newInstance();
            System.out.println(person1);

            Object person2 = cls1.newInstance();
            System.out.println(person2);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(){
        /*3. 获取成员方法们
        - Method[] 	getMethods()
        - Method   getMethod(String name,类<?>...parameterTypes)
        - Method[] 	getDeclaredMethods()                                        //含有Declared的方法不会获取父类的方法
        - Method    getDeclaredMethod(String name,类<?>...parameterTypes)*/
        try {
            //获取指定名称的方法
            Method eatMethod1 = cls1.getMethod("eat");
            Method eatMethod2 = cls1.getMethod("eat",String.class);
            Person p = new Person();
            //执行方法
            eatMethod1.invoke(p);
            eatMethod2.invoke(p,"dumplings");
            System.out.println("------------------------------");
            //获取所有public修饰的方法
            Method[] methods = cls1.getMethods();
            for (Method i:methods) {
                System.out.println(i);
                String methodName = i.getName();
                System.out.println(methodName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void d(){
        /*4. 获取类名
        - getName()*/
        //获取类名
        String className = cls1.getName();
        System.out.println(className);//全类名：包名+类名
    }

    public static void main(String[] args) {
//        ReflectDemo02 rd2 = new ReflectDemo02();
//        rd2.d();
//        short i = 1;
//        i = i + 1;
//        byte i = 1;
//        i = i + 1;
//        char i = 1;
//        i = i + 1;
    }
}
