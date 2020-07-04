import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.tools.jar.Main;


import java.io.IOException;

public class CBTests {

    @Test
    public void testParse() throws IOException {
        Bot.loadCurrencies();
        String expected = "Курс ЦБ РФ на 22/05/2020\n" +
                "GBP : 86.5556\n" +
                "USD : 70.924\n" +
                "EUR : 77.7965\n" +
                "CNY : 9.98916\n" +
                "JPY : 0.65838\n";
        String actual = CBDataLoader.getRate("22/05/2020");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void loseParseTest() throws IOException {
        String expected = "Курс ЦБ РФ на 22/05/2020\n" +
                "GBP : 86.3619\n" +
                "USD : 69.9513\n" +
                "EUR : 78.6812\n" +
                "CNY : 9.88278\n" +
                "JPY : 0.652683\n";
        String actual = CBDataLoader.getRate("22/05/2020");
        Assertions.assertFalse(expected.equals(actual));
    }

    @Test
    public void brokenDate() throws IOException {
        String expected = "Не верно указана дата";
        String actual = CBDataLoader.getRate("32/05/2020");
        Assertions.assertEquals(expected, actual);
    }
}
