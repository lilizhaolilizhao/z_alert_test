package com.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * Created by chaoli.lcl on 2015/5/11.
 */
public class PerfMonAgent {
    private static Instrumentation inst = null;

    /**
     * This method is called before the application¡¯s main-method is called,
     * when this agent is specified to the Java VM.
     **/
    public static void premain(String agentArgs, Instrumentation _inst) {
        if (ConfigConst.INVALID_LOG == Boolean.TRUE)
            System.out.println("PerfMonAgent.premain() was called.");
        // Initialize the static variables we use to track information.
        inst = _inst;
        // Set up the class-file transformer.
        ClassFileTransformer trans = new PerfMonXformer();
        if (ConfigConst.INVALID_LOG == Boolean.TRUE)
            System.out.println("Adding a PerfMonXformer instance to the JVM.");
        inst.addTransformer(trans);
    }
}
