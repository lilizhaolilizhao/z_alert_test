package com.oneapm.guice.LinkedBindings;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(DatabaseTransactionLog.class).to(MySqlDatabaseTransactionLog.class);

        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
    }
}
