package com.oneapm;

import com.sun.btrace.annotations.*;

import static com.sun.deploy.trace.Trace.print;
import static com.sun.deploy.trace.Trace.println;

@BTrace
public class HelloWorld {

    @OnMethod(clazz="java.lang.Thread", method="start")
    public static void onThreadStart(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod) {
        println("thread start! entered " + probeClass + "."  + probeMethod);
    }

    @OnMethod(clazz="/javax\\.swing\\..*/", method="/.*/")
    public static void swingMethods(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod) {
        print("entered " + probeClass + "."  + probeMethod);
    }
}