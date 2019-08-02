package com.oneapm;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yangchj
 * @email yangchj@icefire.me
 * @date 2018/7/6
 */
public class BytemanDemo {

    public static void main(String[] args) {
        new BytemanDemo().start();
    }

    private void start() {
        new Thread(() -> {
            DataInputStream in = new DataInputStream(System.in);
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            try {
                String next = buf.readLine();
                while (next != null && !next.contains("end")) {
                    consume(next);
                    next = buf.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void consume(String text) {
        final String arg = text;
        Thread thread = new Thread(() -> System.out.println("program confirm " + arg));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}