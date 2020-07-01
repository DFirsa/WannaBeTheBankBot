import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;

public class BankRatesParser {

    private static final String urlPattern = "https://ru.myfin.by/currency/";
    public static LinkedList<String> currencies = new LinkedList<>();

    public static String getRatesByCurrency(String city, String currency, String sort) throws IOException {
        String result = "";

        Document doc = Jsoup.connect(urlPattern + currency + "/" + city + sort).get();
        Elements table = doc.select("#g_bank_rates > table > tbody > tr");
        int counter = 0;
        for (Element el: table){
            if(!el.attr("data-key").equals("")) {
                Elements info = el.select("td.bank_name > a");
                String data = info.text() + " : ";
                data += el.select("td:nth-child(2)").text() + " | " +
                        el.select("td:nth-child(3)").text() + "\n";
                result += data;
                counter++;
            }
            if (counter == 5)break;
        }

        return currency.toUpperCase() + "\n" + result;
    }

    public static String getRatesByCity(String city) throws IOException {
        String result = "";
        for (String valute: currencies){
            result += getRatesByCurrency(city, valute, "");
        }
        return result;
    }
}
