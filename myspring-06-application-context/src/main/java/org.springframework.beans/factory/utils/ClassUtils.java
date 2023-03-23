package org.springframework.beans.factory.utils;

public class ClassUtils {

    public static ClassLoader getDefaultClassLoader(){
        ClassLoader classLoader=null;
        classLoader = Thread.currentThread().getContextClassLoader();
        if(classLoader==null){
            classLoader=ClassUtils.class.getClassLoader();
        }
        return classLoader;

    }

}
