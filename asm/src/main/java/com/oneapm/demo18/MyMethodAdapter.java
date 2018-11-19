//package com.oneapm.demo18;
//
//import org.objectweb.asm.MethodVisitor;
//import org.objectweb.asm.tree.MethodNode;
//
//import static org.objectweb.asm.Opcodes.ASM4;
//
//public class MyMethodAdapter extends MethodNode {
//    MethodVisitor next;
//
//    public MyMethodAdapter(int access, String name, String desc,
//                           String signature, String[] exceptions, MethodVisitor mv) {
//        super(ASM4, new MethodNode(access, name, desc, signature, exceptions));
//        next = mv;
//    }
//
//    @Override
//    public void visitEnd() {
//        MethodNode mn = (MethodNode) mv; //将你的转换代码放在这儿
//        mn.accept(next);
//    }
//}
