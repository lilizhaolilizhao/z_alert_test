package com.oneapm.demo3;


import com.oneapm.main.MyClassLoader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.objectweb.asm.Opcodes.*;

public class ASMTest {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ClassWriter cw = new ClassWriter(0);
        PrintWriter printWriter = new PrintWriter(System.out);

        TraceClassVisitor visitor = new TraceClassVisitor(cw, printWriter);
        visitor.visit(V1_7, ACC_PUBLIC, "com/oneapm/demo3/AddOperImpl", null, "java/lang/Object",
                new String[]{"com/oneapm/demo3/AddOper"});


        //添加构造方法
        MethodVisitor mv = visitor.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        mv.visitInsn(RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();

        // 添加add方法
        mv = visitor.visitMethod(ACC_PUBLIC, "add", "(II)I", null, null);
        mv.visitCode();
        mv.visitVarInsn(ILOAD, 1);
        mv.visitVarInsn(ILOAD, 2);
        mv.visitInsn(IADD);
        mv.visitInsn(IRETURN);
        mv.visitMaxs(2, 3);
        mv.visitEnd();

        visitor.visitEnd();

//        FileOutputStream fos = new FileOutputStream(new File("/Users/oneapm/git/z_alert_test/asm/AddOperImpl.class"));
//        fos.write(cw.toByteArray());
//        fos.close();

        MyClassLoader classLoader = new MyClassLoader();
        Class<?> clazz = classLoader.defineClass("com.oneapm.demo3.AddOperImpl", cw.toByteArray());
        Method addMethod = clazz.getMethod("add", int.class, int.class);
        Object result = addMethod.invoke(clazz.newInstance(), 10, 20);
        if (result != null && result instanceof Integer)
            System.out.println(result);
    }
}
