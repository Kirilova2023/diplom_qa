# Дипломный проект по профессии «Тестировщик»
Дипломный проект — автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.


**План автоматизации**

[plan.md](https://github.com/Kirilova2023/diplom_qa/blob/master/documents/plan.md)

**Отчёт по тестированию**

[report.md](https://github.com/Kirilova2023/diplom_qa/blob/master/documents/report.md)

**Общий итог автоматизированного тестирования**

[summary.md](https://github.com/Kirilova2023/diplom_qa/blob/master/documents/summary.md)

**Скриншот Allure**

[!AllureScreen](/documents/Screenshoots/allure_screenshot.png)

## Запуск авто-тестов
Для запуска необходимы следующие инструменты:
* Git
* Java Jre/Jdk 15
* браузер Google Chrome
* Docker и Docker-compose


1. Запустить образы Docker перейдя в папку проекта и выполнив в терминале 1
   ````
   docker-compose up
   ````
2. Указать данные для подключения приложения в файле ../application/application.properties

Пример для PostgreSQL

    
    spring.datasource.username=postgres
    spring.datasource.password=1
    spring.datasource.url=jdbc:postgresql://localhost:5432/app
    

Пример для MySQL
    
````
    spring.datasource.url=jdbc:mysql://localhost:3306/app?serverTimezone=Europe/Moscow
    spring.datasource.username=root
    spring.datasource.password=1234
   ````

3. Во втором терминале запустить приложение командой    
    ````
    java -jar application/aqa-shop.jar
    ````    

4. В браузере Chrome открыть приложение по адресу указанному ниже и убедиться что приложение работает.

    ````
    http://localhost:8080/
    ````

5. В build.gradle внести конфигурацию для используемой СУБД

    -  для MySql

    ````
    systemProperty 'db.url', System.getProperty('db.url','jdbc:mysql://localhost:3306/app?serverTimezone=Europe/Moscow')
    systemProperty 'db.user', System.getProperty('db.user', 'app')
    systemProperty 'db.pass', System.getProperty('db.pass', 'app')    
    ````

    - для postgresql

    ````
    systemProperty 'db.url', System.getProperty('db.url','jdbc:postgresql://localhost:5432/app')
    systemProperty 'db.user', System.getProperty('db.user', 'app')
    systemProperty 'db.pass', System.getProperty('db.pass', 'app')  
    ````
6. Запустить тесты командой 
   ````
   gradlew test
   ````

7. По окончании тестирования, остановить выполнение контейнеров Docker и приложения путём нажатия Ctrl+C  

    
