package com.oneapm.guice.javaAnnotations;

public class Testable {
    public void execute() {
        System.out.println("Executing...");
    }

    @Test
    void testExecute() {
        execute();
    }
}
