package com.xian.reflect;

import com.xian.test.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo02 {
    //0.��ȡPerson��Class����
    Class cls1 = Person.class;

    public void a(){
        /* 1. ��ȡ��Ա������
        - Field[] getFields()                   //��ȡ����public���εĳ�Ա����
        - Field getField(String name)           //��ȡָ�����Ƶ�public���εĳ�Ա����
        - Field[] getDeclaredFields()           //��ȡ���г�Ա���������������η�
	    - Field getDeclaredField(String name)*/

        //1.��ȡ��Ա����
        Field[] fields = cls1.getFields();//��ȡ����public���εĳ�Ա����
        for (Field i:fields) {
            System.out.println(i);
        }
        System.out.println("------------------------------");
        try {
            //��ȡ��Ա����a��ֵ
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
            //���Է���Ȩ�����εİ�ȫ���
            declaredFielName.setAccessible(true);//��������
            Object o = declaredFielName.get(person);
            declaredFielName.set(person,"lisi");
            System.out.println(person);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(){
        /*2. ��ȡ���췽����
        - Constructor<?>[] getConstructors()
        - Constructor<?> getConstructor(��<?>...parameterTypes)
        - Constructor<?>[] getDeclaredConstructors()
        - Constructor<?> getDeclaredConstructor(��<?>...parameterTypes)*/

        //Constructor<?> getDeclaredConstructor(��<?>...parameterTypes)
        try {
            Constructor cst = cls1.getConstructor(String.class, Integer.class);
            System.out.println(cst);
            //��������
            Object person = cst.newInstance("����",23);
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
        /*3. ��ȡ��Ա������
        - Method[] 	getMethods()
        - Method   getMethod(String name,��<?>...parameterTypes)
        - Method[] 	getDeclaredMethods()                                        //����Declared�ķ��������ȡ����ķ���
        - Method    getDeclaredMethod(String name,��<?>...parameterTypes)*/
        try {
            //��ȡָ�����Ƶķ���
            Method eatMethod1 = cls1.getMethod("eat");
            Method eatMethod2 = cls1.getMethod("eat",String.class);
            Person p = new Person();
            //ִ�з���
            eatMethod1.invoke(p);
            eatMethod2.invoke(p,"dumplings");
            System.out.println("------------------------------");
            //��ȡ����public���εķ���
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
        /*4. ��ȡ����
        - getName()*/
        //��ȡ����
        String className = cls1.getName();
        System.out.println(className);//ȫ����������+����
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
