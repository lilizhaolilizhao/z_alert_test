package com.oneapm.guice.BindingAnnotations;

import com.google.inject.Inject;
import com.oneapm.guice.getstart.CreditCardProcessor;
import com.oneapm.guice.getstart.TransactionLog;

public class RealBillingService implements BillingService {

    @Inject
    public RealBillingService(@PayPal CreditCardProcessor processor,
                              TransactionLog transactionLog) {
    }
}
