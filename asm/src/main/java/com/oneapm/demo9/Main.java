package com.oneapm.demo9;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("com.oneapm.demo9.Test");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassAdapter classAdapter = new ClassAdapter(cw);
        cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
        byte[] data = cw.toByteArray();

        FileOutputStream fos = new FileOutputStream(new File("/Users/oneapm/git/z_alert_test/asm/Test2.class"));
        fos.write(data);
        fos.close();
    }
}
