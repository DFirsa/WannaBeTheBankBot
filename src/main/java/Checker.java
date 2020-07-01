import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Checker {

    public static LinkedList<String> currencies = new LinkedList<>();

    public static boolean hasValute(String val){
        return currencies.contains(val);
    }
}
