# Дипломный проект по профессии «Тестировщик»
Дипломный проект — автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.


**План автоматизации**

[plan.md](https://github.com/Kirilova2023/diplom_qa/blob/master/documents/plan.md)

**Отчёт по тестированию**

[report.md](https://github.com/Kirilova2023/diplom_qa/blob/master/documents/report.md)

**Общий итог автоматизированного тестирования**

[summary.md](https://github.com/Kirilova2023/diplom_qa/blob/master/documents/summary.md)

## Запуск авто-тестов
Для запуска необходимы следующие инструменты:
* Git
* Java Jre/Jdk 15
* браузер Google Chrome
* Node.js версии 18.17.0 
* СУБД: Mysql 8.1 и/или Postgres 15.


1. Запустить "заглушку" платежного сервиса перейдя в папку gate-simulator и выполнив в терминале 1
   ````
   npm start
   ````
2. Установить/запустить требуемую СУБД, создать пустую базу данных (например, app) 
3. Создать пользователя с полными правами доступа к указанной СУБД либо, использовать системного пользователя root / postgres 
4. Указать данные для подключения приложения в файле ../application/application.properties

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

5. Во втором терминале запустить приложение командой    
    ````
    java -jar application/aqa-shop.jar
    ````    

6. В браузере Chrome открыть приложение по адресу указанному ниже и убедиться что приложение работает.

    ````
    http://localhost:8080/
    ````

7. В build.gradle внести конфигурацию для используемой СУБД

    -  для MySql

    ````
    systemProperty 'db.url', System.getProperty('db.url','jdbc:mysql://localhost:3306/app?serverTimezone=Europe/Moscow')
    systemProperty 'db.user', System.getProperty('db.user', 'root')
    systemProperty 'db.pass', System.getProperty('db.pass', '1234')    
    ````

    - для postgresql

    ````
    systemProperty 'db.url', System.getProperty('db.url','jdbc:postgresql://localhost:5432/app')
    systemProperty 'db.user', System.getProperty('db.user', 'postgres')
    systemProperty 'db.pass', System.getProperty('db.pass', '1')  
    ````
8. Запустить тесты командой 
   ````
   gradlew test
   ````

9. По окончании тестирования, остановить выполнение gate-simulator и приложения путём нажатия Ctrl+C  

    
