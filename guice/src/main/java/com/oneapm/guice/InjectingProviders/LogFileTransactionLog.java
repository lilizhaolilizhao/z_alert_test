package com.oneapm.guice.InjectingProviders;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class LogFileTransactionLog implements TransactionLog {
    private final Provider<LogFileEntry> logFileProvider;

    @Inject
    public LogFileTransactionLog(Provider<LogFileEntry> logFileProvider) {
        this.logFileProvider = logFileProvider;
    }

    public void logChargeResult(ChargeResult result) {
        LogFileEntry summaryEntry = logFileProvider.get();
        summaryEntry.setText("Charge " + (result.wasSuccessful() ? "success" : "failure"));
        summaryEntry.save();

        if (!result.wasSuccessful()) {
            LogFileEntry detailEntry = logFileProvider.get();
            detailEntry.setText("Failure result: " + result);
            detailEntry.save();
        }
    }

}
