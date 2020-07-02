import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import myEx.groupNoInputInfoException;
import myEx.haveNoTextException;
import org.telegram.telegrambots.api.objects.Message;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public class InputProcessor {

    private static LinkedList<String> cbPatterns;
    private static LinkedList<String> searchPatterns;
    private static HashMap<String, String> regions;
    private static HashMap<String, String> currency;
    private static String region = "moskva";

    public static void load() throws IOException {
        cbPatterns = new LinkedList<>();
        searchPatterns = new LinkedList<>();

        BufferedReader reader = new BufferedReader(new FileReader
                (new File("./src/main/resources/patterns/searchPattern.txt")));

        String line = reader.readLine();
        while (line != null){
            Checker.currencies.add(line);
            searchPatterns.add(line);
            line = reader.readLine();
        }
        reader.close();
        reader = new BufferedReader(new FileReader
                (new File("./src/main/resources/patterns/CBPatterns.txt")));

        line = reader.readLine();
        while (line != null){
            Checker.currencies.add(line);
            cbPatterns.add(line);
            line = reader.readLine();
        }
        reader.close();

        Gson gson = new Gson();
        regions = gson.fromJson(new JsonReader(new FileReader
                ("./src/main/resources/patterns/Banks.json")),
                new TypeToken<HashMap<String, String>>(){}.getType());
        currency = gson.fromJson(new JsonReader(new FileReader
                        ("./src/main/resources/patterns/currenciesPattern.json")),
                new TypeToken<HashMap<String, String>>(){}.getType());
    }

    public static String handleInput(Message message) throws IOException, haveNoTextException, groupNoInputInfoException {
            if (message.hasText()){
                String[] words = message.getText().split("\\s+");
                boolean isSearch = false;
                boolean isCb = false;
                String currency = "";
                String date = "";
                String enteredRegion = "";

                for (int i = 0; i < words.length; i++){
                    String word = words[i];

                    if (word.equals("/help")){
                        //TODO help
                    }

                    if(word.equals("/start")){
                        return "Привет, я бот для вывода информации о курсах валют," +
                                " если хочешь узнать как я работаю просто напиши /help";
                    }

                    if(enteredRegion.isEmpty()) enteredRegion = getRegion(word);
                    if(currency.isEmpty()) currency = getCurrency(word);
                    if(!isSearch) isSearch = isSearch(word);
                    if(!isCb) isCb = isCbRates(word);
                    if(date.isEmpty()) date = getDate(word);

                    if(isCb){
                        if(!date.isEmpty())
                            return CBDataLoader.getRate(date);
                        if(i == words.length - 1)
                            return CBDataLoader.getRate(getTime(message.getDate()));
                    }
                    else {
                        if(isSearch || !currency.isEmpty()){
                            if(!enteredRegion.isEmpty()) region = enteredRegion;
                            if(!currency.isEmpty() && !enteredRegion.isEmpty())
                                return BankRatesParser.getRatesByCurrency(region, currency,
                                        "?sort=buy_course_19", true);
                            if(i == words.length - 1){
                                if(enteredRegion.isEmpty() && !currency.isEmpty()) return BankRatesParser.getRatesByCurrency(region, currency,
                                        "?sort=buy_course_19", true);
                                return BankRatesParser.getRatesByCity(region);
                            }

                        }
                    }
                }
            }
            else if(!message.isGroupMessage())throw new haveNoTextException();
            if(message.isGroupMessage()) throw new groupNoInputInfoException();
            return "Не достаточно информации для вывода информации";
    }

    public static String getRegion(String word){
        for (Map.Entry<String, String> item : regions.entrySet()){
            if (Pattern.matches(item.getKey(), word.toLowerCase())) return item.getValue();
        }
        return "";
    }

    public static String getCurrency(String word){
        for (Map.Entry<String, String> item : currency.entrySet()){
            if (Pattern.matches(item.getKey(), word.toLowerCase())) return item.getValue();
        }
        return "";
    }

    public static boolean isCbRates(String word){
        for (String pattern: cbPatterns){
            if(Pattern.matches(pattern, word.toLowerCase()))
                return true;
        }
        return false;
    }

    public static boolean isSearch(String word){
        for (String pattern: searchPatterns){
            if(Pattern.matches(pattern, word.toLowerCase()))
                return true;
        }
        return false;
    }

    public static String getDate(String word){
        String pattern = "[0-9]{2}[\\/.][0-9]{2}[\\/.][0-9]{4}";
        if (Pattern.matches(pattern, word))
            return word.replaceAll("\\.","\\/");
        return "";
    }

    private static String getTime(long unix){
        Date date = new Date(unix*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
