package com.oneapm.demo18;

import org.objectweb.asm.tree.*;

import java.util.ListIterator;

import static org.objectweb.asm.Opcodes.*;

public class OptimizeJumpTransformer extends MethodTransformer {
    public OptimizeJumpTransformer(MethodTransformer mt) {
        super(mt);
    }

    @Override
    public void transform(MethodNode mn) {
        InsnList insns = mn.instructions;
        ListIterator<AbstractInsnNode> i = insns.iterator();
        while (i.hasNext()) {
            AbstractInsnNode in = i.next();
            if (in instanceof JumpInsnNode) {
                LabelNode label = ((JumpInsnNode) in).label;
                AbstractInsnNode target;
                // 当 target == goto l，用 l 代替 label
                while (true) {
                    target = label;
                    while (target != null && target.getOpcode() < 0) {
                        target = target.getNext();
                    }
                    if (target != null && target.getOpcode() == GOTO) {
                        label = ((JumpInsnNode) target).label;
                    } else {
                        break;
                    }
                }

                // 更新目标
                ((JumpInsnNode) in).label = label;
                // 在可能时，用目标指令代替跳转
                if (in.getOpcode() == GOTO && target != null) {
                    int op = target.getOpcode();
                    if ((op >= IRETURN && op <= RETURN) || op == ATHROW) {
                        // replace ’in’ with clone of ’target’
                        insns.set(in, target.clone(null));
                    }
                }
            }
        }

        super.transform(mn);
    }
}
