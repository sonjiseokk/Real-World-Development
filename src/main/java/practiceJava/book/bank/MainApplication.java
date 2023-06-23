package practiceJava.book.bank;

import practiceJava.book.bank.domain.BankTransaction;
import practiceJava.book.bank.parser.BankStatementCSVParser;
import practiceJava.book.bank.parser.BankStatementParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class MainApplication {
    public static void main(final String... args) throws IOException {

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }


}
