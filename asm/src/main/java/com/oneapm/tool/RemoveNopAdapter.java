package com.oneapm.tool;

import jdk.internal.org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.NOP;

public class RemoveNopAdapter extends MethodVisitor {
    public RemoveNopAdapter(MethodVisitor mv) {
        super(ASM4, mv);
    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode != NOP) {
            super.visitInsn(opcode);
        }
    }
}
