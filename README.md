## Описание
Приложение "Калькулятор отпускных".
Микросервис на SpringBoot + Java 11 c одним API:
GET "/calculacte"

Минимальные требования: 
Приложение принимает твою среднюю зарплату за 12 месяцев и количество дней отпуска - 
отвечает суммой отпускных, которые придут сотруднику.
Доп. задание: При запросе также можно указать точные дни ухода в отпуск, 
тогда должен проводиться рассчет отпускных с учётом праздников и выходных.

## Запуск приложения:
Запустите : NeoflexTestAppApplication в пакете: neoflex.app.neoflextestapp;

или командой mvn spring-boot:run


Приложение доступно по адресу http://localhost:8080/

Выполните запрос (подставляя свои значения)
Например,базовый запрос, нужно указать averageSalary :
http://localhost:8080/calculate?averageSalary=50000&vacationDays=15

запрос с учетом праздников и выходных, нужно указать averageSalary, vacationDays, startDate :
http://localhost:8080/calculate?averageSalary=50000&vacationDays=15&startDate=2024-09-01

 