package com.oneapm.demo6;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;

import static org.objectweb.asm.Opcodes.*;

public class PublicizeMethodAdapter2 extends ClassVisitor {
    PrintWriter pw = new PrintWriter(System.out);
    TraceClassVisitor tracer;

    public PublicizeMethodAdapter2(ClassVisitor cv) {
        super(ASM4, cv);
        this.cv = cv;
        tracer = new TraceClassVisitor(cv, pw);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (name.equals("toUnsignedString0")) {
            return tracer.visitMethod(ACC_PUBLIC + ACC_STATIC,
                    name,
                    desc,
                    signature,
                    exceptions);
        }
        return tracer.visitMethod(access, name, desc, signature, exceptions);
    }

    @Override
    public void visitEnd() {
        tracer.visitEnd();
        System.out.println(tracer.p.getText());
    }
}
