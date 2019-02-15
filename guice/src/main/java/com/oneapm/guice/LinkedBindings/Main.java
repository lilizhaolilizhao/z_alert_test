package com.oneapm.guice.LinkedBindings;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BillingModule());
        BillingService service = injector.getInstance(BillingService.class);

        service.chargeOrder();
    }
}
