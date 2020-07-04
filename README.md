# О проекте

Телеграм-бот для вывода информации о курсах валют городах с населением больше 500.000 человек, и курсе, предоставляемом ЦБ РФ.  
---
### Доступные валюты:
* USD
* EUR
* GBP
* CNY
* JPY
### Доступные города:
1. Москва
2. Санкт-Петербург
3. Новосибирск
4. Екатеринбург
5. Казань
6. Нижний Новгород
7. Челябинск
8. Самара
9. Омск
10. Ростов
11. Уфа
12. Красноярск
13. Воронеж
14. Пермь
15. Волгоград
16. Краснодар
17. Саратов
18. Тюмень
19. Тольятти
20. Ижевск
21. Барнаул
22. Ульяновск
23. Иркутск
24. Хабаровск
25. Ярославль
26. Владивосток
27. Махачкала
28. Томск
29. Оренбург
30. Кемерово
31. Новокузнецк
32. Рязань
33. Набережные челны
34. Астрахань
35. Пенза
36. Киров
37. Липецк
38. Балашиха

Информация по регионам берётся с [этого сайта](https://ru.myfin.by/currency)

# Подготовка бота

1. Перейдите в телеграм-чат [@BotThather](https://t.me/botfather)
2. Отправьте команду `/newBot` для создание нового бота и следуйте инструкциям
3. Вы получите токен бота
4. Отправьте команду `/setjoingroups` чтобы иметь возможность добавить бота в групповой чат
5. Отправьте команду `/setprivacy` и установите статус `DISABLED` чтобы бот мог реагировать на сообщения не начинающиеся с `/`

# Установка

### Heroku

Вам потребуется аккаунт [heroku](https://dashboard.heroku.com/) и [github](https://github.com/)
1. [Сделайте копию](https://github.com/DFirsa/WannaBeTheBankBot/fork) этого репозитория на свой аккаунт github
2. [Создайте](https://dashboard.heroku.com/new-app) новое приложение на heroku
3. Укажите название приложения и установите регион (для большей производительности установите Europe)
4. В графе `Deployment method` установите `GitHub` и укажите клонированный репозиторий ([получится так](http://prntscr.com/tbtpz8))
5. В графе `Automatic deploys` установите `EnableAutomaticDeploys` из ветки `master` ([получится так](http://prntscr.com/tbtu1r))
6. Откройте файл `botInfo.txt` и запишите в первую строку токен вашего бота, а во вторую - имя (токен и имя получены в 3 пункте подготовки бота), сделайте коммит изменений
7. Бот готов к работе

### Локально

1. Установите [Java JDK8](https://www.oracle.com/ru/java/technologies/javase/javase-jdk8-downloads.html) если вы этого еще не сделали 
2. [Скачайте](https://github.com/DFirsa/WannaBeTheBankBot/archive/master.zip) этот репозиторий и распакуйте в любое удобное место
3. Откройте файл `botInfo.txt` и запишите в первую строку токен вашего бота, а во вторую - имя (токен и имя получены в 3 пункте подготовки бота)
4. Для запуска, введите в командную строку следующее 
```java
java src.main.java.Bot
``` 
# Библиотеки и зависимости
Вам потребуется [Java JDK8](https://www.oracle.com/ru/java/technologies/javase/javase-jdk8-downloads.html)
### Используемые библиотеки c Maven зависимостями
* [Jsoup](https://github.com/jhy/jsoup)
```
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.13.1</version>
</dependency>
```
* [telegrambots](https://github.com/rubenlagus/TelegramBots)
```
<dependency>
   <groupId>org.telegram</groupId>
   <artifactId>telegrambots</artifactId>
   <version>3.6</version>
</dependency>
```
* [Junit5](https://github.com/junit-team/junit5)
```
<dependency>
   <groupId>org.junit.jupiter</groupId>
   <artifactId>junit-jupiter-api</artifactId>
   <version>5.7.0-M1</version>
   <scope>test</scope>
</dependency>
```
* [Gson](https://github.com/google/gson)
```
<dependency>
   <groupId>com.google.code.gson</groupId>
   <artifactId>gson</artifactId>
   <version>2.8.6</version>
</dependency>
```

