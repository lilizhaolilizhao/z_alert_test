package com.oneapm.demo2;

import com.sun.xml.internal.ws.org.objectweb.asm.MethodAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class ChangeToChildConstructorMethodAdapter extends MethodAdapter {
    private String superClassName;

    public ChangeToChildConstructorMethodAdapter(MethodVisitor mv, String superClassName) {
        super(mv);
        this.superClassName = superClassName;
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        if (opcode == Opcodes.INVOKESPECIAL && name.equals("<init>")) {
            owner = superClassName;
        }

        super.visitMethodInsn(opcode, owner, name, desc);
    }
}
