package practiceJava.book.bank.parser;

import practiceJava.book.bank.domain.BankTransaction;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFrom(String line);

    List<BankTransaction> parseLinesFrom(List<String> lines);
}
