package com.xian.Annotation;

import java.lang.annotation.*;

/**
  * @author Xian
 元注解：用于描述注解的注解
  * @Target：描述注解能够作用的位置
  * @Retention：描述注解被保留的一个阶段
  * @Documented：描述注解是否被抽取到API文档中
  * @Inherited：描述注解是否被子类继承
 */
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})//表示MyAnno3这个注解只能作用于类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno3 {
}
