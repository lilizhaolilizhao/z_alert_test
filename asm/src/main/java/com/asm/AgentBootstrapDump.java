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

        {
            mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "loadOrDefineClassLoader", "(Ljava/io/File;)Ljava/lang/ClassLoader;", null, new String[]{"java/lang/Throwable"});
            mv.visitCode();
            mv.visitFieldInsn(GETSTATIC, "com/taobao/arthas/agent/AgentBootstrap", "arthasClassLoader", "Ljava/lang/ClassLoader;");
            Label l0 = new Label();
            mv.visitJumpInsn(IFNONNULL, l0);
            mv.visitTypeInsn(NEW, "com/taobao/arthas/agent/ArthasClassloader");
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_1);
            mv.visitTypeInsn(ANEWARRAY, "java/net/URL");
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/File", "toURI", "()Ljava/net/URI;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/net/URI", "toURL", "()Ljava/net/URL;", false);
            mv.visitInsn(AASTORE);
            mv.visitMethodInsn(INVOKESPECIAL, "com/taobao/arthas/agent/ArthasClassloader", "<init>", "([Ljava/net/URL;)V", false);
            mv.visitFieldInsn(PUTSTATIC, "com/taobao/arthas/agent/AgentBootstrap", "arthasClassLoader", "Ljava/lang/ClassLoader;");
            mv.visitLabel(l0);
            mv.visitFrame(F_SAME, 0, null, 0, null);
            mv.visitFieldInsn(GETSTATIC, "com/taobao/arthas/agent/AgentBootstrap", "arthasClassLoader", "Ljava/lang/ClassLoader;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(6, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "initSpy", "(Ljava/lang/ClassLoader;)V", null, new String[]{"java/lang/ClassNotFoundException", "java/lang/NoSuchMethodException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitLdcInsn("com.taobao.arthas.core.advisor.AdviceWeaver");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/ClassLoader", "loadClass", "(Ljava/lang/String;)Ljava/lang/Class;", false);
            mv.visitVarInsn(ASTORE, 1);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitLdcInsn("methodOnBegin");
            mv.visitIntInsn(BIPUSH, 7);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/Class");
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_0);
            mv.visitFieldInsn(GETSTATIC, "java/lang/Integer", "TYPE", "Ljava/lang/Class;");
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_1);
            mv.visitLdcInsn(Type.getType("Ljava/lang/ClassLoader;"));
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_2);
            mv.visitLdcInsn(Type.getType("Ljava/lang/String;"));
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_3);
            mv.visitLdcInsn(Type.getType("Ljava/lang/String;"));
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_4);
            mv.visitLdcInsn(Type.getType("Ljava/lang/String;"));
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_5);
            mv.visitLdcInsn(Type.getType("Ljava/lang/Object;"));
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitIntInsn(BIPUSH, 6);
            mv.visitLdcInsn(Type.getType("[Ljava/lang/Object;"));
            mv.visitInsn(AASTORE);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Class", "getMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitLdcInsn("methodOnReturnEnd");
            mv.visitInsn(ICONST_1);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/Class");
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_0);
            mv.visitLdcInsn(Type.getType("Ljava/lang/Object;"));
            mv.visitInsn(AASTORE);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Class", "getMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitLdcInsn("methodOnThrowingEnd");
            mv.visitInsn(ICONST_1);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/Class");
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_0);
            mv.visitLdcInsn(Type.getType("Ljava/lang/Throwable;"));
            mv.visitInsn(AASTORE);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Class", "getMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
            mv.visitVarInsn(ASTORE, 4);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitLdcInsn("methodOnInvokeBeforeTracing");
            mv.visitInsn(ICONST_4);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/Class");
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_0);
            mv.visitFieldInsn(GETSTATIC, "java/lang/Integer", "TYPE", "Ljava/lang/Class;");
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_1);
            mv.visitLdcInsn(Type.getType("Ljava/lang/String;"));
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_2);
            mv.visitLdcInsn(Type.getType("Ljava/lang/String;"));
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_3);
            mv.visitLdcInsn(Type.getType("Ljava/lang/String;"));
            mv.visitInsn(AASTORE);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Class", "getMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
            mv.visitVarInsn(ASTORE, 5);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitLdcInsn("methodOnInvokeAfterTracing");
            mv.visitInsn(ICONST_4);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/Class");
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_0);
            mv.visitFieldInsn(GETSTATIC, "java/lang/Integer", "TYPE", "Ljava/lang/Class;");
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_1);
            mv.visitLdcInsn(Type.getType("Ljava/lang/String;"));
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_2);
            mv.visitLdcInsn(Type.getType("Ljava/lang/String;"));
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_3);
            mv.visitLdcInsn(Type.getType("Ljava/lang/String;"));
            mv.visitInsn(AASTORE);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Class", "getMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
            mv.visitVarInsn(ASTORE, 6);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitLdcInsn("methodOnInvokeThrowTracing");
            mv.visitInsn(ICONST_4);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/Class");
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_0);
            mv.visitFieldInsn(GETSTATIC, "java/lang/Integer", "TYPE", "Ljava/lang/Class;");
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_1);
            mv.visitLdcInsn(Type.getType("Ljava/lang/String;"));
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_2);
            mv.visitLdcInsn(Type.getType("Ljava/lang/String;"));
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_3);
            mv.visitLdcInsn(Type.getType("Ljava/lang/String;"));
            mv.visitInsn(AASTORE);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Class", "getMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
            mv.visitVarInsn(ASTORE, 7);
            mv.visitLdcInsn(Type.getType("Lcom/taobao/arthas/agent/AgentBootstrap;"));
            mv.visitLdcInsn("resetArthasClassLoader");
            mv.visitInsn(ICONST_0);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/Class");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Class", "getMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
            mv.visitVarInsn(ASTORE, 8);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitVarInsn(ALOAD, 6);
            mv.visitVarInsn(ALOAD, 7);
            mv.visitVarInsn(ALOAD, 8);
            mv.visitMethodInsn(INVOKESTATIC, "java/arthas/Spy", "initForAgentLauncher", "(Ljava/lang/ClassLoader;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(8, 9);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC + ACC_SYNCHRONIZED, "main", "(Ljava/lang/String;Ljava/lang/instrument/Instrumentation;)V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            Label l1 = new Label();
            Label l2 = new Label();
            mv.visitTryCatchBlock(l0, l1, l2, "java/lang/Throwable");
            Label l3 = new Label();
            Label l4 = new Label();
            mv.visitTryCatchBlock(l3, l4, l2, "java/lang/Throwable");
            Label l5 = new Label();
            Label l6 = new Label();
            mv.visitTryCatchBlock(l5, l6, l2, "java/lang/Throwable");
            Label l7 = new Label();
            Label l8 = new Label();
            Label l9 = new Label();
            mv.visitTryCatchBlock(l7, l8, l9, "java/lang/Throwable");
            mv.visitLabel(l0);
            mv.visitFieldInsn(GETSTATIC, "com/taobao/arthas/agent/AgentBootstrap", "ps", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("Arthas server agent start...");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitIntInsn(BIPUSH, 59);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "indexOf", "(I)I", false);
            mv.visitVarInsn(ISTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "substring", "(II)Ljava/lang/String;", false);
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "length", "()I", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "substring", "(II)Ljava/lang/String;", false);
            mv.visitVarInsn(ASTORE, 4);
            mv.visitTypeInsn(NEW, "java/io/File");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKESPECIAL, "java/io/File", "<init>", "(Ljava/lang/String;)V", false);
            mv.visitVarInsn(ASTORE, 5);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/File", "exists", "()Z", false);
            mv.visitJumpInsn(IFNE, l3);
            mv.visitFieldInsn(GETSTATIC, "com/taobao/arthas/agent/AgentBootstrap", "ps", "Ljava/io/PrintStream;");
            mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
            mv.visitLdcInsn("Agent jar file does not exist: ");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitLabel(l1);
            mv.visitInsn(RETURN);
            mv.visitLabel(l3);


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
