package com.oneapm.asm;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.FieldVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class AccessClassAdapter extends ClassAdapter {
    public AccessClassAdapter(ClassVisitor cv) {
        super(cv);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        int privateAccess = Opcodes.ACC_PRIVATE;
        return super.visitField(privateAccess, name, desc, signature, value);
    }
}
