package com.oneapm.demo;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassReader;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Generator {
    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("com.oneapm.demo.Account");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
        cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
        byte[] data = cw.toByteArray();

        File file = new File("Account.class");

        System.out.println(file.getAbsolutePath());
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.close();
    }
}
