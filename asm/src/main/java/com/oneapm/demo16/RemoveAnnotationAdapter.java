package com.oneapm.demo16;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;

import static org.objectweb.asm.Opcodes.ASM4;

public class RemoveAnnotationAdapter extends ClassVisitor {
    private String annDesc;
    public RemoveAnnotationAdapter(ClassVisitor cv, String annDesc) {
        super(ASM4, cv);
        this.annDesc = annDesc;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        if (desc.equals(annDesc)) {
            return null;
        }
        return super.visitAnnotation(desc, visible);
    }
}
