package com.oneapm.demo10;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM5;

public class PersonVistor extends ClassVisitor {
    public PersonVistor(ClassVisitor classVisitor) {
        super(ASM5, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (name.equals("showInfo")) {
            return new RedefineAdvice(mv, access, name, descriptor);
        } else {
            return mv;
        }
    }
}
