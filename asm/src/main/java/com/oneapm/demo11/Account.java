package com.oneapm.demo11;

import java.util.Date;

public class Account {
    public void operation() {
        System.out.println("operation...: new : " + new Date());
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

