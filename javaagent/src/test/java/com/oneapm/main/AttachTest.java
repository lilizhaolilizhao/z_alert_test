package com.oneapm.main;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

//args[0]传入的是jvm的pid号
public class AttachTest {
    public static void main(String[] args) throws AttachNotSupportedException,
            IOException, AgentLoadException, AgentInitializationException {
        VirtualMachine vm = VirtualMachine.attach(args[0]);
        vm.loadAgent("D:\\git\\z_akka-kafka\\z_alert_test\\javaagent\\target\\javaagent-jar-with-dependencies.jar");
        vm.detach();
    }

}