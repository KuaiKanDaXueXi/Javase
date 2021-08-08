package com.xian.Annotation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 简单测试框架
 *
 * 当主方法执行后，会自动自行被检测的所有方法（加了@Check注解的方法），判断方法是否有异常，记录到文件中
 */
public class TestCheck {
    public static void main(String[] args) throws Exception {
        //1.创建计算器对象
        Caculator caculator = new Caculator();
        //2.获取字节码文件对象
        Class cc = caculator.getClass();
        Object o = cc.newInstance();

        //3.获取所有的方法
        Method[] methods = cc.getMethods();

        int count = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("Bug.txt"));

        for (Method method:methods){
            //4.判断方法上是否有Check注解
            if (method.isAnnotationPresent(Check.class)) {
                //5.有，执行
                try {
                    method.invoke(caculator);
                } catch (Exception e){
//                    e.printStackTrace();
                    //6.捕获异常
                    count++;
                    //记录到文件信息
                    bw.write('`'+method.getName()+'`'+" 方法出异常了");
                    bw.newLine();
                    bw.write("异常名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("=======================================");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现"+count+"次异常");
        bw.flush();


        //6.捕获异常
        Class<TestCheck> cls = TestCheck.class;
        Check ann = cls.getAnnotation(Check.class);
    }
}
