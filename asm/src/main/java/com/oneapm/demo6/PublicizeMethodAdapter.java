package com.oneapm.demo6;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class PublicizeMethodAdapter extends ClassVisitor {
    public PublicizeMethodAdapter(ClassVisitor cv) {
        super(ASM4, cv);
        this.cv = cv;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (name.equals("toUnsignedString0")) {
            return cv.visitMethod(ACC_PUBLIC + ACC_STATIC,
                    name,
                    desc,
                    signature,
                    exceptions);
        }
        return cv.visitMethod(access, name, desc, signature, exceptions);
    }
}
