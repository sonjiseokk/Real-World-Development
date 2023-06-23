package practiceJava.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practiceJava.book.bank.domain.BankTransaction;
import practiceJava.book.bank.parser.BankStatementCSVParser;
import practiceJava.book.bank.parser.BankStatementParser;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BankStatementCSVParserTest {
    private final BankStatementParser statementParser = new BankStatementCSVParser();


    @Test
    @DisplayName("트랜젝션이 생성 가능한지")
    public void shouldParseOneCorrectLine() throws Exception{
        final String line = "30-01-2017,-50,Tesco";
        final BankTransaction result = statementParser.parseFrom(line);

        assertThat(result.getDate()).isEqualTo(LocalDate.of(2017, Month.JANUARY, 30));
        assertThat(result.getAmount()).isEqualTo(-50);
        assertThat(result.getDescription()).isEqualTo("Tesco");
    }

    @Test
    @DisplayName("트랜젝션 조건 중 하나라도 부족할 때")
    public void shouldCheckNullParameter(){
        final String line = "30-01-2017,-50,";
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            BankTransaction result = statementParser.parseFrom(line);
        });

//        assertThat(result.getDate()).isEqualTo(LocalDate.of(2017, Month.JANUARY, 30));
//        assertThat(result.getAmount()).isEqualTo(-50);
//        assertThat(result.getDescription()).isEqualTo("Tesco");
    }
}
