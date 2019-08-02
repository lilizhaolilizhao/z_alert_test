package com.oneapm;

import java.util.Map;

public class Test {

    public static void main(String[] args) throws InterruptedException {
//        while (true) {
//            Thread.sleep(5000L);
//            System.out.println("this is a test!!!");
//        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        System.out.println(allStackTraces);
    }
}
