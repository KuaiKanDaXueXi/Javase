package com.xian.Annotation;

import java.lang.annotation.*;

/**
  * @author Xian
 Ԫע�⣺��������ע���ע��
  * @Target������ע���ܹ����õ�λ��
  * @Retention������ע�ⱻ������һ���׶�
  * @Documented������ע���Ƿ񱻳�ȡ��API�ĵ���
  * @Inherited������ע���Ƿ�����̳�
 */
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})//��ʾMyAnno3���ע��ֻ������������
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno3 {
}
