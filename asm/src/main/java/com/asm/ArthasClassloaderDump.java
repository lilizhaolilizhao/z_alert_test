package com.asm;

import org.objectweb.asm.*;

import java.io.FileOutputStream;

public class ArthasClassloaderDump implements Opcodes {

    public static byte[] dump() throws Exception {
        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, "com/taobao/arthas/agent/ArthasClassloader", null, "java/net/URLClassLoader", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "([Ljava/net/URL;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/ClassLoader", "getSystemClassLoader", "()Ljava/lang/ClassLoader;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/ClassLoader", "getParent", "()Ljava/lang/ClassLoader;", false);
            mv.visitMethodInsn(INVOKESPECIAL, "java/net/URLClassLoader", "<init>", "([Ljava/net/URL;Ljava/lang/ClassLoader;)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 2);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PROTECTED + ACC_SYNCHRONIZED, "loadClass", "(Ljava/lang/String;Z)Ljava/lang/Class;", "(Ljava/lang/String;Z)Ljava/lang/Class<*>;", new String[]{"java/lang/ClassNotFoundException"});
            mv.visitCode();
            Label l0 = new Label();
            Label l1 = new Label();
            Label l2 = new Label();
            mv.visitTryCatchBlock(l0, l1, l2, "java/lang/Exception");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/taobao/arthas/agent/ArthasClassloader", "findLoadedClass", "(Ljava/lang/String;)Ljava/lang/Class;", false);
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 3);
            Label l3 = new Label();
            mv.visitJumpInsn(IFNULL, l3);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitInsn(ARETURN);
            mv.visitLabel(l3);
            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"java/lang/Class"}, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitJumpInsn(IFNULL, l0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitLdcInsn("sun.");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "startsWith", "(Ljava/lang/String;)Z", false);
            Label l4 = new Label();
            mv.visitJumpInsn(IFNE, l4);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitLdcInsn("java.");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "startsWith", "(Ljava/lang/String;)Z", false);
            mv.visitJumpInsn(IFEQ, l0);
            mv.visitLabel(l4);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitMethodInsn(INVOKESPECIAL, "java/net/URLClassLoader", "loadClass", "(Ljava/lang/String;Z)Ljava/lang/Class;", false);
            mv.visitInsn(ARETURN);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/taobao/arthas/agent/ArthasClassloader", "findClass", "(Ljava/lang/String;)Ljava/lang/Class;", false);
            mv.visitVarInsn(ASTORE, 4);
            mv.visitVarInsn(ILOAD, 2);
            Label l5 = new Label();
            mv.visitJumpInsn(IFEQ, l5);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/taobao/arthas/agent/ArthasClassloader", "resolveClass", "(Ljava/lang/Class;)V", false);
            mv.visitLabel(l5);
            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"java/lang/Class"}, 0, null);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitLabel(l1);
            mv.visitInsn(ARETURN);
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_FULL, 4, new Object[]{"com/taobao/arthas/agent/ArthasClassloader", "java/lang/String", Opcodes.INTEGER, "java/lang/Class"}, 1, new Object[]{"java/lang/Exception"});
            mv.visitVarInsn(ASTORE, 4);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitMethodInsn(INVOKESPECIAL, "java/net/URLClassLoader", "loadClass", "(Ljava/lang/String;Z)Ljava/lang/Class;", false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(3, 5);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }

    public static void main(String[] args) {
        try {
            byte[] code = dump();

            FileOutputStream fos = new FileOutputStream("/Users/oneapm/git/z_alert_test/asm/target/Example.class");
            fos.write(code);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
