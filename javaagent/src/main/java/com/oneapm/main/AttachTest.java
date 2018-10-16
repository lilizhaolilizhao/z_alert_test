package com.oneapm.main;

import com.sun.tools.attach.VirtualMachine;

public class AttachTest {

    /**
     * 传入的是jvm的pid号
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        VirtualMachine vm = VirtualMachine.attach(args[0]);
        vm.loadAgent("D:\\git\\z_akka-kafka\\z_alert_test\\javaagent\\target\\javaagent-jar-with-dependencies.jar");
        vm.detach();
    }

}
