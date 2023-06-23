package practiceJava.book.bank;

import practiceJava.book.bank.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize(double accmulator, BankTransaction bankTransaction);
}
