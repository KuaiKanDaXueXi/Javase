package com.xian.reflect;

import com.xian.test.Person;
import com.xian.test.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo03 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Student.class;
        Object o = cls.newInstance();
        Method setName = cls.getDeclaredMethod("setName", String.class);
        Method getName = cls.getDeclaredMethod("getName");
        cls.getDeclaredMethod("getAge");
        setName.invoke(o,"zhangsan");
        System.out.println(getName.invoke(o));

    }
}
