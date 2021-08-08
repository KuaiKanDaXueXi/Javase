package com.xian.Annotation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * �򵥲��Կ��
 *
 * ��������ִ�к󣬻��Զ����б��������з���������@Checkע��ķ��������жϷ����Ƿ����쳣����¼���ļ���
 */
public class TestCheck {
    public static void main(String[] args) throws Exception {
        //1.��������������
        Caculator caculator = new Caculator();
        //2.��ȡ�ֽ����ļ�����
        Class cc = caculator.getClass();
        Object o = cc.newInstance();

        //3.��ȡ���еķ���
        Method[] methods = cc.getMethods();

        int count = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("Bug.txt"));

        for (Method method:methods){
            //4.�жϷ������Ƿ���Checkע��
            if (method.isAnnotationPresent(Check.class)) {
                //5.�У�ִ��
                try {
                    method.invoke(caculator);
                } catch (Exception e){
//                    e.printStackTrace();
                    //6.�����쳣
                    count++;
                    //��¼���ļ���Ϣ
                    bw.write('`'+method.getName()+'`'+" �������쳣��");
                    bw.newLine();
                    bw.write("�쳣���ƣ�"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("�쳣ԭ��"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("=======================================");
                    bw.newLine();
                }
            }
        }
        bw.write("���β���һ������"+count+"���쳣");
        bw.flush();


        //6.�����쳣
        Class<TestCheck> cls = TestCheck.class;
        Check ann = cls.getAnnotation(Check.class);
    }
}
