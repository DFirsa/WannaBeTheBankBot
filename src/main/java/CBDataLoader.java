import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CBDataLoader {

    private static final String urlPattern = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=";

    public static String getRate(String date) throws IOException {
        Document doc = Jsoup.connect(urlPattern + date).get();
        Elements valutes = doc.select("Valute");

        String result = "";
        for (Element el : valutes){
            String valute = el.select("CharCode").text();
            if(Checker.hasValute(valute)){
                double nominal = Double.valueOf(el.select("Nominal").text());
                double value = Double.valueOf(el.select("Value").text().replace(',','.'));
                result += valute + " : " + value / nominal + "\n";
            }
        }

        return "Курс ЦБ РФ\n" + result;
    }
}
