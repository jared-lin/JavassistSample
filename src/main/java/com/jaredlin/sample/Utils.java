package com.jaredlin.sample;

import javassist.*;

/**
 * Created by linmq on 2017/7/23.
 */
public class Utils {
    public static void addStringField(CtClass ctClass, String name, String value) throws NotFoundException, CannotCompileException {
        CtClass type = ClassPool.getDefault().get("java.lang.String");
        CtField f = new CtField(type,name,ctClass);
        CtField.Initializer init = CtField.Initializer.constant(value);
        ctClass.addField(f,init);
    }
    public static void rename(CtClass ctClass, String name){
        ctClass.setName(name);
    }

}
