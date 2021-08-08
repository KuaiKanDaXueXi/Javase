package com.xian.reflect;

import com.xian.Annotation.Pro;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
@Pro(className = "com.xian.Annotation.Demo1",methodName="show")
public class ReflectTest {
    public static void main(String[] args) {
        //可以执行创建任意类的对象，可以去执行任意方法
        /*前提：不能改变该类的任何代码，可以执行创建任意类的对象，可以去执行任意方法。*/
        //1.解析注解
        //1.1获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //1.2获取上面的注解对象
        Pro an = reflectTestClass.getAnnotation(Pro.class);//其实就是在内存中生成了一个该注解接口的子类实现对象
        //2.调用注解中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();
        try {
            //3.加载该类进内存
            Class cls = Class.forName(className);
            //4.创建对象
            Object o = cls.newInstance();
            //5.获取方法
            Method method = cls.getMethod(methodName);
            //6.执行方法
            method.invoke(o);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
