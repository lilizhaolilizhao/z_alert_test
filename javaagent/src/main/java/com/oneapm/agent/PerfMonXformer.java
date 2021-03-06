package com.oneapm.agent;

import javassist.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 监控类
 */
public class PerfMonXformer implements ClassFileTransformer {


    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        byte[] transformed = null;
        if (ConfigConst.INVALID_LOG == Boolean.TRUE)
            System.out.println("Transforming " + className);
        ClassPool pool = ClassPool.getDefault();
        CtClass cl = null;
        try {
            cl = pool.makeClass(new java.io.ByteArrayInputStream(
                    classfileBuffer));
            if (cl.isInterface() == false) {
                CtBehavior[] methods = cl.getDeclaredBehaviors();
                for (int i = 0; i < methods.length; i++) {
                    if (!methods[i].isEmpty()) {
                        doMethod(methods[i]);
                    }
                }
                transformed = cl.toBytecode();
            }
        } catch (Exception e) {
            System.err.println("Could not instrument  " + className
                    + ",  exception : " + e.getMessage());
        } finally {
            if (cl != null) {
                cl.detach();
            }
        }
        return transformed;
    }

    private void doMethod(CtBehavior method) throws NotFoundException,
            CannotCompileException {

        method.addLocalVariable("startTime", CtClass.longType);
        method.insertBefore("System.out.println(startTime);");
        method.insertBefore("startTime = System.currentTimeMillis();");
//			method.insertBefore("long startTime = System.currentTimeMillis();System.out.println(startTime);");
        method.insertBefore("System.out.println(\"insert before ......\");");
        method.insertAfter("System.out.println(\"leave " + method.getName() + " and time is :\" + (System.currentTimeMillis() - startTime));");
//            method.insertBefore("long stime = System.nanoTime();");
//            method.insertAfter("System.out.println(\"leave " + method.getName() + " and time:\"+(System.nanoTime()-stime));");
//            method.instrument(new ExprEditor() {
//                public void edit(MethodCall m) throws CannotCompileException {
//                    m.replace("{ long stime = System.nanoTime(); $_ = $proceed($$); System.out.println(\""
//                            + m.getClassName()
//                            + "."
//                            + m.getMethodName()
//                            + ":\"+(System.nanoTime()-stime));===================================================}");
//
//                }
//            });
    }
}
