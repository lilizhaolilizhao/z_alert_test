package com.oneapm.tool;

import org.objectweb.asm.ClassWriter;

public class ClassWriteTest {
    public static void main(String[] args) {
//        ClassWriter classWriter = new ClassWriter(0);
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
    }
}
