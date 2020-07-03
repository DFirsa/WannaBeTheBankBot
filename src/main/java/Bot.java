import myEx.groupNoInputInfoException;
import myEx.haveNoTextException;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class Bot extends TelegramLongPollingBot {

    private static final String attentionURL =
            "https://i0.wp.com/angolenko.com.ua/news/wp-content/uploads/2019/06/original-4.png?fit=512%2C512&ssl=1";
    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        try {
            loadCurrencies();
            InputProcessor.load();
        } catch (IOException e) {
            logger.warning("Lose data files");
        }
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            logger.warning("Error bot launching");
        }
    }

    private void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);

        try{
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            logger.warning("Error sending message");
        }
    }

    private void sendAttention(Message message) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setPhoto(attentionURL);
        sendPhoto.setCaption("Дай текст!!!");
        sendPhoto.setChatId(message.getChatId().toString());
        sendPhoto(sendPhoto);
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null) {
            try {
                sendMsg(message, InputProcessor.handleInput(message));
            } catch (IOException e) {
                logger.warning("Error loading info from data files");
            } catch (haveNoTextException e) {
                try {
                    sendAttention(message);
                } catch (TelegramApiException telegramApiException) {
                    logger.warning("Error sending attention message");
                }
            } catch (groupNoInputInfoException ignored){}
        }
    }

    public String getBotUsername() {
        return "Wanna be the bank";
    }

    public String getBotToken() {
        return "1336671453:AAHXogwPaeTWD5hBOaFOrXNZsXxbpM8qD_k";
    }

    private String getDate(long unixSeconds){
        Date date = new java.util.Date(unixSeconds*1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public static void loadCurrencies() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("./src/main/resources/currencies.txt")));

        String line = reader.readLine();
        while (line != null){
            Checker.currencies.add(line);
            BankRatesParser.currencies.add(line);
            line = reader.readLine();
        }
        reader.close();
    }
}
