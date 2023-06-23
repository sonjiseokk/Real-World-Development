package practiceJava.book;

import org.junit.jupiter.api.Test;
import practiceJava.book.bank.BankStatementAnalyzer;
import practiceJava.book.bank.BankStatementProcessor;
import practiceJava.book.bank.domain.BankTransaction;
import practiceJava.book.bank.parser.BankStatementCSVParser;
import practiceJava.book.bank.parser.BankStatementParser;

import java.time.Month;
import java.util.List;

public class MinMaxTransactionTest {
    private final BankStatementParser statementParser = new BankStatementCSVParser();
    final String line = "30-01-2017,-50,Tesco";

//    private final BankStatementProcessor statementProcessor = new BankStatementProcessor();


//    @Test
//    public BankTransaction maxValueInSelectedMonth(List<BankTransaction> bankTransactions, Month month){
//
//        final List<BankTransaction> bankTransactionsInMonth = selectInMonth(bankTransactions, month);
//        BankTransaction temp = bankTransactionsInMonth.get(0);
//
//        for (BankTransaction bankTransaction : bankTransactionsInMonth) {
//            if (temp.getAmount() < bankTransaction.getAmount()) {
//                temp = bankTransaction;
//            }
//        }
//
//        return max;
//    }
}
