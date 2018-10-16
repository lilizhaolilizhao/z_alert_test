package com.oneapm.agent;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
public class LoadedAgent {

    public static void premain(String agentArgs, Instrumentation _inst) {
        main(agentArgs, _inst);
    }

    public static void agentmain(String args, Instrumentation _inst){
        main(args, _inst);
    }

    private static void main(String args, Instrumentation _inst) {
//        Class[] classes = _inst.getAllLoadedClasses();
//        for(Class cls :classes){
//            System.out.println(cls.getName());
//        }

        if (ConfigConst.INVALID_LOG == Boolean.TRUE)
            System.out.println("PerfMonAgent main was called.");
        // Initialize the static variables we use to track information.
        // Set up the class-file transformer.
        ClassFileTransformer trans = new PerfMonXformer();
        if (ConfigConst.INVALID_LOG == Boolean.TRUE)
            System.out.println("Adding a PerfMonXformer instance to the JVM.");
        _inst.addTransformer(trans);
    }
}
