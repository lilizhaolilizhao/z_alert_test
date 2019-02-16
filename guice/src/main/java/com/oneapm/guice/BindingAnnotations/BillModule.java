package com.oneapm.guice.BindingAnnotations;

import com.google.inject.AbstractModule;
import com.oneapm.guice.getstart.CreditCardProcessor;

public class BillModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CreditCardProcessor.class)
                .annotatedWith(PayPal.class)
                .to(PayPalCreditCardProcessor.class);
    }
}
