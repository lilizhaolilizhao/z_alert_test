package com.oneapm.demo10;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

public class RedefineAdvice extends AdviceAdapter {
    protected RedefineAdvice(MethodVisitor methodVisitor, int access, String name, String descriptor) {
        super(ASM5, methodVisitor, access, name, descriptor);
    }


    @Override
    protected void onMethodEnter() {
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

        super.onMethodEnter();
    }
}
