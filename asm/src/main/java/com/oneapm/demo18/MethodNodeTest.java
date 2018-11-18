package com.oneapm.demo18;

import org.objectweb.asm.tree.*;

import static org.objectweb.asm.Opcodes.*;

public class MethodNodeTest {
    public static void main(String[] args) {
        MethodNode mn = new MethodNode(ASM7);
        InsnList il = mn.instructions;
        il.add(new VarInsnNode(ILOAD, 1));
        LabelNode label = new LabelNode();
        il.add(new JumpInsnNode(IFLT, label));
        il.add(new VarInsnNode(ALOAD, 0));
        il.add(new VarInsnNode(ILOAD, 1));
        il.add(new FieldInsnNode(PUTFIELD, "pkg/Bean", "f", "I"));
        LabelNode end = new LabelNode();
        il.add(new JumpInsnNode(GOTO, end));
        il.add(label);
        il.add(new FrameNode(F_SAME, 0, null, 0, null));
        il.add(new TypeInsnNode(NEW, "java/lang/IllegalArgumentException"));
        il.add(new InsnNode(DUP));
        il.add(new MethodInsnNode(INVOKESPECIAL,
                "java/lang/IllegalArgumentException", "<init>", "()V"));
        il.add(new InsnNode(ATHROW));
        il.add(end);
        il.add(new FrameNode(F_SAME, 0, null, 0, null));
        il.add(new InsnNode(RETURN));
        mn.maxStack = 2;
        mn.maxLocals = 2;
    }
}
