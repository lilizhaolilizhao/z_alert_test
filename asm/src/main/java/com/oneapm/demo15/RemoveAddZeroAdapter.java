package com.oneapm.demo15;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class RemoveAddZeroAdapter extends MethodVisitor  {
    protected final static int SEEN_NOTHING = 0;
    protected int state;
    private static int SEEN_ICONST_0 = 1;

    public RemoveAddZeroAdapter(MethodVisitor mv) {
        super(ASM4, mv);
    }

    @Override
    public void visitInsn(int opcode) {
        if (state == SEEN_ICONST_0) {
            if (opcode == IADD) {
                state = SEEN_NOTHING;
                return;
            } else {
                mv.visitInsn(ICONST_0);
                state = SEEN_NOTHING;
            }
        }

        if (opcode == ICONST_0) {
            state = SEEN_ICONST_0;
            return;
        }
        mv.visitInsn(opcode);
    }
}
