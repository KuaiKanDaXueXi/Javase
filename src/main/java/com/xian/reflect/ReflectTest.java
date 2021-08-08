package com.xian.reflect;

import com.xian.Annotation.Pro;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
@Pro(className = "com.xian.Annotation.Demo1",methodName="show")
public class ReflectTest {
    public static void main(String[] args) {
        //����ִ�д���������Ķ��󣬿���ȥִ�����ⷽ��
        /*ǰ�᣺���ܸı������κδ��룬����ִ�д���������Ķ��󣬿���ȥִ�����ⷽ����*/
        //1.����ע��
        //1.1��ȡ������ֽ����ļ�����
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //1.2��ȡ�����ע�����
        Pro an = reflectTestClass.getAnnotation(Pro.class);//��ʵ�������ڴ���������һ����ע��ӿڵ�����ʵ�ֶ���
        //2.����ע���ж���ĳ��󷽷�����ȡ����ֵ
        String className = an.className();
        String methodName = an.methodName();
        try {
            //3.���ظ�����ڴ�
            Class cls = Class.forName(className);
            //4.��������
            Object o = cls.newInstance();
            //5.��ȡ����
            Method method = cls.getMethod(methodName);
            //6.ִ�з���
            method.invoke(o);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
