package com.oneapm.demo17;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassNode cn = new ClassNode();
        ClassReader cr = new ClassReader("");
        cr.accept(cn, 0);

        ClassWriter cw = new ClassWriter(0);
        cn.accept(cw);
        byte[] b = cw.toByteArray();
    }
}
