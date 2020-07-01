import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.regex.Pattern;

public class BankRatesParserTests {

    @Test
    public void parseManyTest() throws IOException {
        String actual = BankRatesParser.getRatesByCurrency("sankt-peterburg", "GBP", "?sort=bank_name");
        String expected = "GBP\n" +
                "Ак Барс Банк : [0-9]{1,3}.{0,1}[0-9]{0,2} \\| [0-9]{1,3}.{0,1}[0-9]{0,2}\n" +
                "Альфа-Банк : [0-9]{1,3}.{0,1}[0-9]{0,2} \\| [0-9]{1,3}.{0,1}[0-9]{0,2}\n" +
                "ББР Банк : [0-9]{1,3}.{0,1}[0-9]{0,2} \\| [0-9]{1,3}.{0,1}[0-9]{0,2}\n" +
                "Банк «Санкт-Петербург» : [0-9]{1,3}.{0,1}[0-9]{0,2} \\| [0-9]{1,3}.{0,1}[0-9]{0,2}\n" +
                "Банк ВТБ : [0-9]{1,3}.{0,1}[0-9]{0,2} \\| [0-9]{1,3}.{0,1}[0-9]{0,2}\n";

        Assertions.assertTrue(Pattern.matches(expected, actual));
    }

    @Test
    public void parseLessThenFiveTest() throws IOException {
        String actual = BankRatesParser.getRatesByCurrency("perm", "CNY", "?sort=bank_name");
        String expected = "CNY\n" +
                "Банк ВТБ : [0-9]{1,3}.{0,1}[0-9]{0,2} \\| [0-9]{1,3}.{0,1}[0-9]{0,2}\n" +
                "Росбанк : [0-9]{1,3}.{0,1}[0-9]{0,2} \\| [0-9]{1,3}.{0,1}[0-9]{0,2}\n";

        Assertions.assertTrue(Pattern.matches(expected,actual));
    }
}
