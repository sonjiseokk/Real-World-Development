package practiceJava.book.bank;

import practiceJava.book.bank.domain.BankTransaction;
import practiceJava.book.bank.domain.BankTransactionFilter2;

public class FindTransactionInCondition implements BankTransactionFilter2 {
    @Override
    public boolean test(BankTransaction bankTransaction) {
        return false;
    }
}
