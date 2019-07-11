//package com.oneapm;
//
//import com.sun.btrace.annotations.BTrace;
//import com.sun.btrace.annotations.OnEvent;
//import com.sun.btrace.annotations.OnMethod;
//import com.sun.btrace.annotations.Self;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@BTrace
//public class HistoOnEvent {
//   private static Map<String, AtomicInteger> histo = new HashMap();
//
//    @OnMethod(
//        clazz="javax.swing.JComponent",
//        method="<init>"
//    )
//    public static void onnewObject(@Self Object obj) {
//        String cn = name(classOf(obj));
//        AtomicInteger ai = get(histo, cn);
//        if (ai == null) {
//            ai = new AtomicInteger(1);
//            put(histo, cn, ai);
//        } else {
//            incrementAndGet(ai);
//        }
//    }
//
//    @OnEvent
//    public static void print() {
//        if (size(histo) != 0) {
//            printNumberMap("Component Histogram", histo);
//        }
//    }
//}