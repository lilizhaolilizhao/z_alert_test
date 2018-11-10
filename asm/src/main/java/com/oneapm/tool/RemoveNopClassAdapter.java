package com.oneapm.tool;

import jdk.internal.org.objectweb.asm.ClassVisitor;

import static org.objectweb.asm.Opcodes.ASM4;

public class RemoveNopClassAdapter extends ClassVisitor {
    public RemoveNopClassAdapter(ClassVisitor cv) {
        super(ASM4, cv);
    }

//    @Override
//    public MethodVisitor visitMethod(int access, String name,
//                                     String desc, String signature, String[] exceptions) {
//        MethodVisitor mv;
//        mv = cv.visitMethod(access, name, desc, signature, exceptions);
////        if (mv != null) {
////            mv = new RemoveNopAdapter(mv);
////        }
//
//        if (mv != null && !name.equals("<init>")) {
//            mv = new RemoveNopAdapter(mv);
//        }
//
//        return mv;
//    }

//    @Override
//    public MethodVisitor visitMethod(int access, String name,
//                                     String desc, String signature, String[] exceptions) {
//        MethodVisitor mv1, mv2;
//        mv1 = cv.visitMethod(access, name, desc, signature, exceptions);
//        mv2 = cv.visitMethod(access, "_" + name, desc, signature, exceptions);
//        return new MultiMethodAdapter(mv1, mv2);
//    }
}
