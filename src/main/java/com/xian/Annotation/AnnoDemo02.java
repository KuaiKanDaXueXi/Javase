package com.xian.Annotation;

import java.util.Date;

/**
 * JDK��һЩԤ�����ע��
 * * @Override ����ⱻ��ע���ע�ķ����Ƿ��Ǽ̳��Ը��ࣨ�ӿڣ���
 * * @Deprecated ������ע���ע�����ݣ���ʾ�ѹ�ʱ
 * * @SuppressWarnings ��ѹ�ƾ����
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
