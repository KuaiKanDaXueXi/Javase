package com.xian.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import org.apache.commons.beanutils.ConvertUtils;

public class ReflectTest02 {
    public String getClassName() throws IOException {
        InputStream is = ReflectTest02.class.getResourceAsStream("pro.properties");
        System.out.println(is);
        Properties prop = new Properties();
        prop.load(is);
        return prop.getProperty("className");
    }
    public Method getMethod(Class c,String methodName) throws NoSuchMethodException {
        return c.getDeclaredMethod(methodName);
    }
    public Field getField(Class c,String field) throws NoSuchFieldException {
        return c.getDeclaredField(field);
    }
    public Class<?> getFieldType(Class c, Field field) throws NoSuchFieldException {
        return field.getType();
    }

    public boolean setValue(Class c, Map<String,String> map) {
            try {
                for (String s : map.keySet()){
                    s = (s.charAt(0)+"").toUpperCase(Locale.ROOT)+s.substring(1);
                    Method method = getMethod(c, "set" + s);
                    method.invoke(c,ConvertUtils.convert(map.get(s), getFieldType(c, getField(c, s))));
                }
                return true;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        return false;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ReflectTest02 rt = new ReflectTest02();
        String className = rt.getClassName();
        Map<String,String> map = new HashMap<>();
        Scanner s = new Scanner(System.in);
        Class<?> c = Class.forName(className);
        Field[] declaredFields = c.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
            map.put(declaredField.getName(),s.next());
        }
        rt.setValue(c,map);
    }
}
