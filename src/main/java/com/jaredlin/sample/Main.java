package com.jaredlin.sample;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;

public class Main {

    public static void main(String[] args) {
        changeReturn();
    }

    public static void changeReturn() {
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass ctClass = pool.getAndRename("com.jaredlin.sample.Animal","ChangeReturn");
            Utils.addStringField(ctClass,"tiger","Tiger");
            CtMethod method = ctClass.getDeclaredMethod("getName");
            CodeAttribute codeAttribute = method.getMethodInfo().getCodeAttribute();
            CodeIterator iterator = codeAttribute.iterator();
            iterator.writeByte(57, 3);
            ctClass.writeFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //addField
    public static void addField(){
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass ctClass = pool.get("com.jaredlin.sample.Animal");
            Utils.rename(ctClass,"AddField");
            Utils.addStringField(ctClass, "weight", "3kg");
            ctClass.writeFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
