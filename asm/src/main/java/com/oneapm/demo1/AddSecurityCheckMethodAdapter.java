//package com.oneapm.demo;
//
//
//import com.sun.xml.internal.ws.org.objectweb.asm.MethodAdapter;
//import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;
//import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;
//
//public class AddSecurityCheckMethodAdapter extends MethodAdapter {
//    public AddSecurityCheckMethodAdapter(MethodVisitor mv) {
//        super(mv);
//    }
//
//    @Override
//    public void visitCode() {
//        visitMethodInsn(Opcodes.INVOKESTATIC, "SecurityChecker", "checkSecurity", "()V");
//    }
//}
