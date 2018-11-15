package com.oneapm.demo14;

public class C {
    public static long timer;

    public void m() throws Exception {
        timer -= System.currentTimeMillis();
        Thread.sleep(100);
        timer += System.currentTimeMillis();
    }
}