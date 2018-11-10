//package com.oneapm.demo5;
//
//import org.objectweb.asm.ClassVisitor;
//import org.objectweb.asm.ClassWriter;
//import org.objectweb.asm.Handle;
//import org.objectweb.asm.Type;
//import org.objectweb.asm.commons.GeneratorAdapter;
//
//import java.lang.reflect.Method;
//import java.util.function.Function;
//
//import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
//import static org.objectweb.asm.Opcodes.V1_7;
//
//public class LambdaTest {
//    public static void main(String[] args) {
//
//    }
//
//    protected byte[] generateLambdaGeneratorClass(
//            final String className,
//            final Class<?> iface, final Method interfaceMethod,
//            final Handle bsmHandle, final Class<?> argumentType) throws Exception {
//
//        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
//        cw.visit(V1_7, ACC_PUBLIC, className, null, Type.getInternalName(Object.class),
//                new String[]{Type.getInternalName(Function.class)});
//
//        generateDefaultConstructor(cw);
//        generateApplyMethod(cw, iface, interfaceMethod, bsmHandle, argumentType);
//
//        cw.visitEnd();
//        return cw.toByteArray();
//    }
//
//    private void generateDefaultConstructor(ClassVisitor cv) {
//        String desc = Type.getMethodDescriptor(Type.getType(void.class));
//        GeneratorAdapter ga = createMethod(cv, ACC_PUBLIC, "", desc);
//        ga.loadThis();
//        ga.invokeConstructor(Type.getType(Object.class),
//                new org.objectweb.asm.commons.Method("", desc));
//        ga.returnValue();
//        ga.endMethod();
//    }
//
//    private void generateApplyMethod(ClassVisitor cv, Class<?> iface,
//                                     Method ifaceMethod, Handle bsmHandle, Class<?> argType) {
//        final Object[] bsmArgs = new Object[]{Type.getType(ifaceMethod),
//                bsmHandle, Type.getType(ifaceMethod)};
//        final String bsmDesc = argType != null ?
//                Type.getMethodDescriptor(Type.getType(iface), Type.getType(argType)) :
//                Type.getMethodDescriptor(Type.getType(iface));
//
//        GeneratorAdapter ga = createMethod(cv, ACC_PUBLIC, "apply",
//                Type.getMethodDescriptor(Type.getType(Object.class),
//                        Type.getType(Object.class)));
//        if (argType != null) {
//            ga.loadArg(0);
//            ga.checkCast(Type.getType(argType));
//        }
//        ga.invokeDynamic(ifaceMethod.getName(), bsmDesc, metafactory, bsmArgs);
//        ga.returnValue();
//        ga.endMethod();
//    }
//
//    private static GeneratorAdapter createMethod(ClassVisitor cv,
//                                                 int access, String name, String desc) {
//        return new GeneratorAdapter(
//                cv.visitMethod(access, name, desc, null, null),
//                access, name, desc);
//    }
//
////    protected byte[] generateLambdaGeneratorClass(
////            final String className, final Class<?> iface, final Method ifaceMethod,
////            final Handle bsmHandle, final Class<?> argType) throws Exception {
////
////        final Object[] bsmArgs = new Object[]{
////                Type.getType(ifaceMethod), bsmHandle, Type.getType(ifaceMethod)};
////        final String bsmDesc = argType != null ? sig(iface, argType) : sig(iface);
////
////        return new JiteClass(className, p(Object.class),
////                new String[]{p(Function.class)}) {{
////            defineDefaultConstructor();
////            defineMethod("apply", ACC_PUBLIC, sig(Object.class, Object.class),
////                    new CodeBlock() {{
////                        if (argumentType != null) {
////                            aload(1);
////                            checkcast(p(argumentType));
////                        }
////                        invokedynamic(ifaceMethod.getName(), bsmDesc, metafactory, bsmArgs);
////                        areturn();
////                    }});a
////        }}.toBytes(JDKVersion.V1_7);
//    }
//}
