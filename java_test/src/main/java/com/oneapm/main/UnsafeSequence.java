package com.oneapm.main;

public class UnsafeSequence {
    private int value;

    public int getNext() {
        return value++;
    }
}
