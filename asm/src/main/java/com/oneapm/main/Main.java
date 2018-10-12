package com.oneapm.main;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.V1_5;

public class Main {
    public static void main(String[] args) {
        try {
//            ClassPrinter cp = new ClassPrinter(262146);
//            ClassReader cr = new ClassReader("java.lang.Runnable");

//            InputStream resourceAsStream = Main.class.getResourceAsStream(Runnable.class.getName().replace(".", "/"));
//            ClassReader cr = new ClassReader(resourceAsStream);
//            cr.accept(cp, 0);

//            ClassWriter cw = new ClassWriter(0);
//            cw.visit(V1_5, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
//                    "pkg/Comparable", null, "java/lang/Object",
//                    new String[] { "pkg/Mesurable" });
//            cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I",
//                    null, new Integer(-1)).visitEnd();
//            cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I",
//                    null, new Integer(0)).visitEnd();
//            cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I",
//                    null, new Integer(1)).visitEnd();
//            cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
//                    "(Ljava/lang/Object;)I", null, null).visitEnd();
//            cw.visitEnd();
//            byte[] b = cw.toByteArray();
//
//            MyClassLoader myClassLoader = new MyClassLoader();
//            Class c = myClassLoader.defineClass("pkg.Comparable", b);
//
//            System.out.println(b);

//            byte[] b1 = new String().getBytes();
//            ClassWriter cw = new ClassWriter(0);
//            ClassReader cr = new ClassReader(b1);
//            cr.accept(cw, 0);
//            byte[] b2 = cw.toByteArray(); // b2 和 b1 表示同一个类

//            byte[] b1 = new String().getBytes();
//            ClassWriter cw = new ClassWriter(0);
//            // cv 将所有事件转发给 cw
//            ClassVisitor cv = new ClassVisitor(ASM4, cw) {};
//            ClassReader cr = new ClassReader(b1);
//            cr.accept(cv, 0);
//            byte[] b2 = cw.toByteArray(); // b2 与 b1 表示同一个类

            byte[] b1 = new String().getBytes();
            ClassReader cr = new ClassReader(b1);
            ClassWriter cw = new ClassWriter(cr, 0);
            ChangeVersionAdapter ca = new ChangeVersionAdapter(cw);
            cr.accept(ca, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class ChangeVersionAdapter extends ClassVisitor {
        public ChangeVersionAdapter(ClassVisitor cv) {
            super(ASM4, cv);
        }

        @Override
        public void visit(int version, int access, String name,
                          String signature, String superName, String[] interfaces) {
            cv.visit(V1_5, access, name, signature, superName, interfaces);
        }
    }

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new ClassFileTransformer() {
            public byte[] transform(ClassLoader l, String name, Class c,
                                    ProtectionDomain d, byte[] b)
                    throws IllegalClassFormatException {
                ClassReader cr = new ClassReader(b);
                ClassWriter cw = new ClassWriter(cr, 0);
                ClassVisitor cv = new ChangeVersionAdapter(cw);
                cr.accept(cv, 0);
                return cw.toByteArray();
            }
        });
    }
}
