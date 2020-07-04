# � �������

��������-��� ��� ������ ���������� � ������ ����� ������� � ���������� ������ 500.000 �������, � �����, ��������������� �� ��.  
---
### ��������� ������:
* USD
* EUR
* GBP
* CNY
* JPY
### ��������� ������:
1. ������
2. �����-���������
3. �����������
4. ������������
5. ������
6. ������ ��������
7. ���������
8. ������
9. ����
10. ������
11. ���
12. ����������
13. �������
14. �����
15. ���������
16. ���������
17. �������
18. ������
19. ��������
20. ������
21. �������
22. ���������
23. �������
24. ���������
25. ���������
26. �����������
27. ���������
28. �����
29. ��������
30. ��������
31. �����������
32. ������
33. ���������� �����
34. ���������
35. �����
36. �����
37. ������
38. ��������

���������� �� �������� ������ � [����� �����](https://ru.myfin.by/currency)

# ���������� ����

1. ��������� � ��������-��� [@BotThather](https://t.me/botfather)
2. ��������� ������� `/newBot` ��� �������� ������ ���� � �������� �����������
3. �� �������� ����� ����
4. ��������� ������� `/setjoingroups` ����� ����� ����������� �������� ���� � ��������� ���
5. ��������� ������� `/setprivacy` � ���������� ������ `DISABLED` ����� ��� ��� ����������� �� ��������� �� ������������ � `/`

# ���������

### Heroku

��� ����������� ������� [heroku](https://dashboard.heroku.com/) � [github](https://github.com/)
1. [�������� �����](https://github.com/DFirsa/WannaBeTheBankBot/fork) ����� ����������� �� ���� ������� github
2. [��������](https://dashboard.heroku.com/new-app) ����� ���������� �� heroku
3. ������� �������� ���������� � ���������� ������ (��� ������� ������������������ ���������� Europe)
4. � ����� `Deployment method` ���������� `GitHub` � ������� ������������� ����������� ([��������� ���](http://prntscr.com/tbtpz8))
5. � ����� `Automatic deploys` ���������� `EnableAutomaticDeploys` �� ����� `master` ([��������� ���](http://prntscr.com/tbtu1r))
6. �������� ���� `botInfo.txt` � �������� � ������ ������ ����� ������ ����, � �� ������ - ��� (����� � ��� �������� � 3 ������ ���������� ����), �������� ������ ���������
7. ��� ����� � ������

### ��������

1. ���������� [Java JDK8](https://www.oracle.com/ru/java/technologies/javase/javase-jdk8-downloads.html) ���� �� ����� ��� �� ������� 
2. [��������](https://github.com/DFirsa/WannaBeTheBankBot/archive/master.zip) ���� ����������� � ���������� � ����� ������� �����
3. �������� ���� `botInfo.txt` � �������� � ������ ������ ����� ������ ����, � �� ������ - ��� (����� � ��� �������� � 3 ������ ���������� ����)
4. ��� �������, ������� � ��������� ������ ��������� 
```java
java src.main.java.Bot
``` 
# ���������� � �����������
��� ����������� [Java JDK8](https://www.oracle.com/ru/java/technologies/javase/javase-jdk8-downloads.html)
### ������������ ���������� c Maven �������������
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

