package com.oneapm.main;

import org.objectweb.asm.ClassReader;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try {
            ClassPrinter cp = new ClassPrinter(262146);
//            ClassReader cr = new ClassReader("java.lang.Runnable");

            InputStream resourceAsStream = Main.class.getResourceAsStream(Runnable.class.getName().replace(".", "/"));
            ClassReader cr = new ClassReader(resourceAsStream);
            cr.accept(cp, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
