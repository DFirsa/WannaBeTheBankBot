import java.util.Arrays;

public class Checker {

    private static final String[] valutes = {"USD", "EUR", "GBP", "CNY", "JPY"};

    public static boolean hasValute(String val){
        return Arrays.asList(valutes).contains(val);
    }
}
