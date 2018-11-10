package com.oneapm.demo3;

import org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;

public class AddOperImpl_Dump {

    public static void main(String[] args) throws Exception {
        byte[] dump = dump();

        FileOutputStream fos = new FileOutputStream(new File("/Users/oneapm/git/z_alert_test/asm/AddOperImpl.class"));
        fos.write(dump);
        fos.close();
    }

    public static byte[] dump() throws Exception {
        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, "com/oneapm/demo3/AddOperImpl", null, "java/lang/Object", new String[]{"com/oneapm/demo3/AddOper"});

        cw.visitSource("AddOperImpl.java", null);

        {
            mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(3, l0);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(Opcodes.RETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "Lcom/oneapm/demo3/AddOperImpl;", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "add", "(II)I", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(6, l0);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitInsn(Opcodes.IADD);
            mv.visitInsn(Opcodes.IRETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "Lcom/oneapm/demo3/AddOperImpl;", null, l0, l1, 0);
            mv.visitLocalVariable("a", "I", null, l0, l1, 1);
            mv.visitLocalVariable("b", "I", null, l0, l1, 2);
            mv.visitMaxs(2, 3);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
