//package com.oneapm.guice.firstdemo;
//
//import com.google.inject.Inject;
//
//public class RealBillingService implements BillingService {
//
//    private final CreditCardProcessor processor;
//    private final TransactionLog transactionLog;
//
//    @Inject
//    public RealBillingService(CreditCardProcessor processor, TransactionLog transactionLog) {
//        this.processor = processor;
//        this.transactionLog = transactionLog;
//    }
//
//    @Override
//    public void chargeOrder() {
//        System.out.println("this is a test!");
//    }
//}
