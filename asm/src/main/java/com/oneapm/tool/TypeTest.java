package com.oneapm.tool;

import org.objectweb.asm.Type;

public class TypeTest {
    public static void main(String[] args) {
        Type returnType = Type.getReturnType("(I)V");
        System.out.println(returnType);

//        String internalName = Type.getType(String.class).getInternalName();
//        System.out.println(internalName);

//        String descriptor = Type.getType(String.class).getDescriptor();
//        System.out.println(descriptor);

//        String descriptor = Type.getType(Integer.class).getDescriptor();
//        System.out.println(descriptor);
//
//        String descriptor1 = Type.INT_TYPE.getDescriptor();
//        System.out.println(descriptor1);
//
//        Type[] argumentTypes = Type.getArgumentTypes("(I)V");
//        System.out.println(argumentTypes);
    }
}
