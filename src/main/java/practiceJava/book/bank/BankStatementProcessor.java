package practiceJava.book.bank;

import practiceJava.book.bank.domain.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;


    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }
    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer){
        double result = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    /**
     *
     * @return 모든 조건의 총수입과 총지출
     */

    public double calculateTotalAmount(){
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    /**
     *
     * @param month
     * @return 특정 달의 총수입과 총지출
     */
    public double calculateTotalInMonth(Month month) {
        return summarizeTransactions((
                (accmulator, bankTransaction) -> bankTransaction.getDate().getMonth() == month
                        ? accmulator + bankTransaction.getAmount()
                        : accmulator)
        );
    }

    /**
     *
     * @param category
     * @return 특정 설명의 총수입과 총지출
     */
    public double calculateTotalForCategory(String category){
        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
    public List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }

    public List<BankTransaction> findTransactionGreaterThanEqual(final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getAmount() >= amount) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    public List<BankTransaction> findTransactionInMonth(Month month) {
        final List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    public List<BankTransaction> findTransactionsInMonthAndGreater(final Month month, final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getAmount() >= amount && bankTransaction.getDate().getMonth() == month) {
                result.add(bankTransaction);
            }
        }

        return result;
    }



    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter){
        final List<BankTransaction> result = new ArrayList<>();

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }


        return result;
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount){
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }


}


