//package com.oneapm.demo;
//
//
//import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
//import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
//import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;
//
//public class AddSecurityCheckClassAdapter extends ClassAdapter {
//    public AddSecurityCheckClassAdapter(ClassVisitor cv) {
//        super(cv);
//    }
//
//    @Override
//    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
//        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
//        MethodVisitor wrappedMv = mv;
//        if (mv != null) {
//            if ("operation".equals(name)) {
//                wrappedMv = new AddSecurityCheckMethodAdapter(mv);
//            }
//        }
//
//        return wrappedMv;
//    }
//}
