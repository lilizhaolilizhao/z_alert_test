package com.oneapm.demo7;

import com.oneapm.demo6.CustomClassWriter;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class Premain {
    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(
                    ClassLoader l,
                    String name,
                    Class c,
                    ProtectionDomain d,
                    byte[] b)
                    throws IllegalClassFormatException {
                try {
                    if (name.equals("java/lang/Integer")) {
                        CustomClassWriter cr = new CustomClassWriter();
                        return cr.addField();
                    }
                } catch (IOException e) {
                }
                return b;
            }
        });
    }
}
