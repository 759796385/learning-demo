package com.newtonk.annotation.best;

import java.lang.annotation.Annotation;

/**
 * Created by newtonk on 2016/11/19.
 */
public class Daili implements Exam {
    private Exam exam;

    public Daili(Exam a) {
        this.exam = a;
    }

    @Override
    public String answer(@Param(onlyStart = "a") String name) {
        Class clazz =exam.getClass();
        java.lang.reflect.Method[] me = clazz.getDeclaredMethods();
        java.lang.reflect.Method answer = me[0];
        Method method = answer.getAnnotation(Method.class);
        String value = method.param();
        Annotation[][] annotations = answer.getParameterAnnotations();//获取参数的所有注解
        for (Annotation[] as : annotations) { //每个参数的维度数组
            for (Annotation param:as) { //每个维度
                if(param instanceof  Param){
                    Param p =  (Param) param;
                    String start = p.onlyStart();
                    if(!name.startsWith(start)){
                        System.out.println("参数值不合法");
                        return null;
                    }
                }
            }
        }
        name = value+name;
        return exam.answer(name);
    }
}
