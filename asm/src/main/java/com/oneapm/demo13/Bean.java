package com.oneapm.demo13;

public class Bean {
    private int f;

    public int getF() {
        return this.f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public void checkAndSetF(int f) {
        if (f >= 0) {
            this.f = f;
        } else {
            throw new IllegalArgumentException();
        }
    }
}