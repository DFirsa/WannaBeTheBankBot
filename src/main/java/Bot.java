import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        try {
            loadCurrencies();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText())
            switch (message.getText()){
                case "/help":
                    break;
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

    private static void loadCurrencies() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("./src/main/resources/currencies.txt")));

        String line = reader.readLine();
        while (line != null){
            Checker.currencies.add(line);
            BankRatesParser.currencies.add(line);
            line = reader.readLine();
        }
    }
}
