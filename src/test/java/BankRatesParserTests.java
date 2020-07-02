import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.regex.Pattern;

public class BankRatesParserTests {

    @Test
    public void parseManyTest() throws IOException {
        String actual = BankRatesParser.getRatesByCurrency("sankt-peterburg", "GBP", "?sort=bank_name", true);
        String expected = "Курс фунта в Санкт-Петербурге:\n\n" +
                "Ак Барс Банк\nПокупка : [0-9]{1,3}.{0,1}[0-9]{0,2}\nПродажа : [0-9]{1,3}.{0,1}[0-9]{0,2}\n\n" +
                "Альфа-Банк\nПокупка : [0-9]{1,3}.{0,1}[0-9]{0,2}\nПродажа : [0-9]{1,3}.{0,1}[0-9]{0,2}\n\n" +
                "ББР Банк\nПокупка : [0-9]{1,3}.{0,1}[0-9]{0,2}\nПродажа : [0-9]{1,3}.{0,1}[0-9]{0,2}\n\n" +
                "Банк «Санкт-Петербург»\nПокупка : [0-9]{1,3}.{0,1}[0-9]{0,2}\nПродажа : [0-9]{1,3}.{0,1}[0-9]{0,2}\n\n" +
                "Банк ВТБ\nПокупка : [0-9]{1,3}.{0,1}[0-9]{0,2}\nПродажа : [0-9]{1,3}.{0,1}[0-9]{0,2}\n\n";

        Assertions.assertTrue(Pattern.matches(expected, actual));
    }

    @Test
    public void parseLessThenFiveTest() throws IOException {
        String actual = BankRatesParser.getRatesByCurrency("perm", "CNY", "?sort=bank_name", true);
        String expected = "Курс юаня в банках Перми:\n\n" +
                "Банк ВТБ\nПокупка : [0-9]{1,3}.{0,1}[0-9]{0,2}\nПродажа : [0-9]{1,3}.{0,1}[0-9]{0,2}\n\n" +
                "Росбанк\nПокупка : [0-9]{1,3}.{0,1}[0-9]{0,2}\nПродажа : [0-9]{1,3}.{0,1}[0-9]{0,2}\n\n";

        Assertions.assertTrue(Pattern.matches(expected,actual));
    }
}
