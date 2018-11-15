package com.oneapm.demo2;

//import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

public class SecureAccountGenerator {
    private static AccountGeneratorClassLoader classLoader = new AccountGeneratorClassLoader();

    private static Class secureAccountClass;

    public static Account generateSecureAccount() throws IOException, IllegalAccessException, InstantiationException {
        if (null == secureAccountClass) {
            ClassReader cr = new ClassReader("com.oneapm.demo2.Account");
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
//            ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
//            cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
            byte[] data = cw.toByteArray();
            secureAccountClass = classLoader.defineClassFromClassFile(
                    "Account$EnhancedByASM", data);
        }

        return (Account) secureAccountClass.newInstance();
    }

    private static class AccountGeneratorClassLoader extends ClassLoader {
        public Class defineClassFromClassFile(String className,
                                              byte[] classFile) throws ClassFormatError {
            return defineClass("com.oneapm.demo2.Account$EnhancedByASM", classFile, 0, classFile.length);
        }
    }

    public static void main(String[] args) throws IllegalAccessException, IOException, InstantiationException {
        Account account = generateSecureAccount();
        System.out.println(account);
    }
}
