package com.oneapm.asm;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

public class DelLoginClassAdapter extends ClassAdapter {
    public DelLoginClassAdapter(ClassVisitor cv) {
        super(cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (name.equals("login")) {
            return null;
        }
        return super.visitMethod(access, name, desc, signature, exceptions);
    }
}
