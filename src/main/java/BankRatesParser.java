import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;

public class BankRatesParser {

    private static final String urlPattern = "https://ru.myfin.by/currency/";
    public static LinkedList<String> currencies = new LinkedList<>();

    public static String getRatesByCurrency(String city, String currency, String sort, boolean justOneCurrency) throws IOException {
        String result = "";

        Document doc = Jsoup.connect(urlPattern + currency + "/" + city + sort).get();
        Elements table = doc.select("#g_bank_rates > table > tbody > tr");
        int counter = 0;
        for (Element el: table){
            if(!el.attr("data-key").equals("")) {
                Elements info = el.select("td.bank_name > a");
                String data = info.text() + "\n";
                data += "Покупка : " + el.select("td:nth-child(2)").text() + "\nПродажа : "
                        + el.select("td:nth-child(2)").text() + "\n\n";
                result += data;
                counter++;
            }
            if (counter == 5)break;
        }

        if (result.isEmpty()) return "Ненаход...\nТут этим не торгуют(((";
        if (justOneCurrency){
            Elements header = doc.select("body > div.container.page_cont > div.row >" +
                    " div.col-md-9.main-container.pos-r.ovf-hidden > div:nth-child(1) >" +
                    " div.content_i-head.content_i-head--datepicker-fix > div.wrapper-flex > div.wrapper-flex__title > h1");
            result = header.text() + ":\n\n"  + result;
        }
        else result = currency.toUpperCase() + "\n" + result;

        return result;
    }

    public static String getRatesByCity(String city) throws IOException {
        String result = "";

        Document doc = Jsoup.connect(urlPattern + city).get();
        Elements header = doc.select("body > div.container.page_cont > div.row >" +
                " div.col-md-9.main-container.pos-r.ovf-hidden > div:nth-child(1) >" +
                " div.content_i-head.content_i-head--datepicker-fix > div.wrapper-flex > div.wrapper-flex__title > h1");

        for (String valute: currencies){
            result += getRatesByCurrency(city, valute, "", false);
        }
        return header.text() + ":\n\n" + result;
    }
}
