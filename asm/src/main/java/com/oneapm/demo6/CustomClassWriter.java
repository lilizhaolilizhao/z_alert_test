package com.oneapm.demo6;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CustomClassWriter {
    AddFieldAdapter addFieldAdapter;
    PublicizeMethodAdapter pubMethAdapter;

    Integer test = new Integer(1);
    static String className = "java.lang.Integer";
    static String cloneableInterface = "java/lang/Cloneable";

    ClassReader reader;
    ClassWriter writer;

    public CustomClassWriter() throws IOException {
        reader = new ClassReader(className);
        writer = new ClassWriter(reader, 0);
    }

    public byte[] addField() {
        addFieldAdapter = new AddFieldAdapter("aNewBooleanField",
                org.objectweb.asm.Opcodes.ACC_PUBLIC, "Z",
                writer);
        reader.accept(addFieldAdapter, 0);
        return writer.toByteArray();
    }

    public byte[] publicizeMethod() {
        pubMethAdapter = new PublicizeMethodAdapter(writer);
        reader.accept(pubMethAdapter, 0);
        return writer.toByteArray();
    }

    public static void main(String[] args) throws IOException {
        CustomClassWriter customClassWriter = new CustomClassWriter();
        byte[] bytes = customClassWriter.addField();

        FileOutputStream fos = new FileOutputStream(new File("/Users/oneapm/git/z_alert_test/asm/Integer.class"));
        fos.write(bytes);
        fos.close();
    }
}
