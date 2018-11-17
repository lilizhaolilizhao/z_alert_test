package com.oneapm.demo17;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.tree.ClassNode;

import static org.objectweb.asm.Opcodes.ASM4;

public class MyClassAdapter extends ClassNode {
    public MyClassAdapter(ClassVisitor cv) {
        super(ASM4);
        this.cv = cv;
    }
    @Override public void visitEnd() {
        // put your transformation code here
        accept(cv);
    }
}
