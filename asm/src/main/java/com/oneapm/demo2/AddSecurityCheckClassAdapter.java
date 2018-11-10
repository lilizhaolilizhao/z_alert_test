package com.oneapm.demo2;


import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

public class AddSecurityCheckClassAdapter extends ClassAdapter {
    public AddSecurityCheckClassAdapter(ClassVisitor cv) {
        super(cv);
    }
    private String enhancedSuperName;

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        String enhancedName = name + "$EnhancedByASM";   // 改变类命名
        enhancedSuperName = name; // 改变父类，这里是”Account”

        super.visit(version, access, enhancedName, signature, enhancedSuperName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor wrappedMv = mv;

        if(mv != null) {
            if (name.equals("operation")) {
                wrappedMv = new AddSecurityCheckMethodAdapter(mv);
            } else if (name.equals("<init>")) {
                wrappedMv = new ChangeToChildConstructorMethodAdapter(mv, enhancedSuperName);
            }
        }

        return wrappedMv;
    }
}
