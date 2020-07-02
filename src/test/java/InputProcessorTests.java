import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class InputProcessorTests {

    @Test
    public void getDateTest1(){
        String expected = "22/06/2020";
        String actual = InputProcessor.getDate(expected);
        Assertions.assertEquals(expected, actual);
        actual = InputProcessor.getDate("22.06.2020");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getDateTest2(){
        String expected = "22/06/2020";
        String actual = InputProcessor.getDate("22.06.2020");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchWordTest1() throws IOException {
        InputProcessor.load();
        boolean actual = InputProcessor.isSearch("курс");
        Assertions.assertTrue(actual);
    }

    @Test
    public void searchWordTest2() throws IOException {
        InputProcessor.load();
        boolean actual = InputProcessor.isSearch("валюта");
        Assertions.assertTrue(actual);
    }

    @Test
    public void cbRateTest1() throws IOException {
        InputProcessor.load();
        boolean actual = InputProcessor.isCbRates("центральный банк");
        Assertions.assertTrue(actual);
    }

    @Test
    public void cbRateTest2() throws IOException {
        InputProcessor.load();
        boolean actual = InputProcessor.isCbRates("банк россии");
        Assertions.assertTrue(actual);
    }

    @Test
    public void getCurrencyTest1() throws IOException {
        InputProcessor.load();
        String expected = "USD";
        String actual = InputProcessor.getCurrency("Доллар");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getCurrencyTest2() throws IOException {
        InputProcessor.load();
        String expected = "JPY";
        String actual = InputProcessor.getCurrency("ены");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getCurrencyTest3() throws IOException {
        InputProcessor.load();
        String expected = "";
        String actual = InputProcessor.getCurrency("рубль");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getRegionTest1() throws IOException {
        InputProcessor.load();
        String expected = "sankt-peterburg";
        String actual = InputProcessor.getRegion("питер");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getRegionTest2() throws IOException {
        InputProcessor.load();
        String expected = "nizhniy-novgorod";
        String actual = InputProcessor.getRegion("нижний новгород");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getRegionTest3() throws IOException {
        InputProcessor.load();
        String expected = "";
        String actual = InputProcessor.getRegion("минск");
        Assertions.assertEquals(expected, actual);
    }
}
