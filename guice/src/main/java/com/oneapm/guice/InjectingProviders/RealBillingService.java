package com.oneapm.guice.InjectingProviders;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class RealBillingService implements BillingService {
    private final Provider<CreditCardProcessor> processorProvider;
    private final Provider<TransactionLog> transactionLogProvider;

    @Inject
    public RealBillingService(Provider<CreditCardProcessor> processorProvider,
                              Provider<TransactionLog> transactionLogProvider) {
        this.processorProvider = processorProvider;
        this.transactionLogProvider = transactionLogProvider;
    }

    @Override
    public void chargeOrder() {
        System.out.println("this is a test!");
    }
}
