package practiceJava.book.bank;

import practiceJava.book.bank.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
