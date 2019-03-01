package com.asm;

import org.objectweb.asm.*;

import java.io.FileOutputStream;

public class AgentBootstrapDump implements Opcodes {
    public static byte[] dump() {
        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, "com/taobao/arthas/agent/AgentBootstrap", null,
                "java/lang/Object", null);

//        cw.visitInnerClass("com/taobao/arthas/agent/AgentBootstrap$1", null, null, ACC_STATIC);

        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "ADVICEWEAVER", "Ljava/lang/String;", null, "com.taobao.arthas.core.advisor.AdviceWeaver");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "ON_BEFORE", "Ljava/lang/String;", null, "methodOnBegin");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "ON_RETURN", "Ljava/lang/String;", null, "methodOnReturnEnd");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "ON_THROWS", "Ljava/lang/String;", null, "methodOnThrowingEnd");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "BEFORE_INVOKE", "Ljava/lang/String;", null, "methodOnInvokeBeforeTracing");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "AFTER_INVOKE", "Ljava/lang/String;", null, "methodOnInvokeAfterTracing");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "THROW_INVOKE", "Ljava/lang/String;", null, "methodOnInvokeThrowTracing");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "RESET", "Ljava/lang/String;", null, "resetArthasClassLoader");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "ARTHAS_SPY_JAR", "Ljava/lang/String;", null, "arthas-spy.jar");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "ARTHAS_CONFIGURE", "Ljava/lang/String;", null, "com.taobao.arthas.core.config.Configure");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "ARTHAS_BOOTSTRAP", "Ljava/lang/String;", null, "com.taobao.arthas.core.server.ArthasBootstrap");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "TO_CONFIGURE", "Ljava/lang/String;", null, "toConfigure");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "GET_JAVA_PID", "Ljava/lang/String;", null, "getJavaPid");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "GET_INSTANCE", "Ljava/lang/String;", null, "getInstance");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "IS_BIND", "Ljava/lang/String;", null, "isBind");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "BIND", "Ljava/lang/String;", null, "bind");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_STATIC, "ps", "Ljava/io/PrintStream;", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_STATIC + ACC_VOLATILE, "arthasClassLoader", "Ljava/lang/ClassLoader;", null, null);
            fv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "premain", "(Ljava/lang/String;Ljava/lang/instrument/Instrumentation;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESTATIC, "com/taobao/arthas/agent/AgentBootstrap", "main", "(Ljava/lang/String;Ljava/lang/instrument/Instrumentation;)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "agentmain", "(Ljava/lang/String;Ljava/lang/instrument/Instrumentation;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESTATIC, "com/taobao/arthas/agent/AgentBootstrap", "main", "(Ljava/lang/String;Ljava/lang/instrument/Instrumentation;)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC + ACC_SYNCHRONIZED, "resetArthasClassLoader", "()V", null, null);
            mv.visitCode();
            mv.visitInsn(ACONST_NULL);
            mv.visitFieldInsn(PUTSTATIC, "com/taobao/arthas/agent/AgentBootstrap", "arthasClassLoader",
                    "Ljava/lang/ClassLoader;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 0);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "getClassLoader", "(Ljava/lang/instrument/Instrumentation;Ljava/io/File;Ljava/io/File;)Ljava/lang/ClassLoader;",
                    null, new String[]{"java/lang/Throwable"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitTypeInsn(NEW, "java/util/jar/JarFile");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESPECIAL, "java/util/jar/JarFile", "<init>", "(Ljava/io/File;)V", false);
            mv.visitMethodInsn(INVOKEINTERFACE, "java/lang/instrument/Instrumentation", "appendToBootstrapClassLoaderSearch", "(Ljava/util/jar/JarFile;)V", true);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKESTATIC, "com/taobao/arthas/agent/AgentBootstrap", "loadOrDefineClassLoader", "(Ljava/io/File;)Ljava/lang/ClassLoader;", false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(4, 3);
            mv.visitEnd();
        }

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
