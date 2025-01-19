# Проверка API для сайта [Reqres](https://reqres.in/)

## Содержание

* <a href="#tools">Инструменты</a>
* <a href="#cases">Тестовое покрытие</a>
* <a href="#launch">Запуск</a>
* <a href="#allure">Отчет в Allure</a>
* <a href="#allureTestOps">Интеграция с Allure TestOps</a>
* <a href="#telegramBot">Бот в Telegram</a>
* <a href="#video">Видео прохождения тестов</a>

---
<a id="tools"></a>

## <a name="Инструменты">**Инструменты**</a>

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/icons/intellij-original.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/icons/jenkins-original.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/icons/github-original.svg" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/icons/java-original.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/icons/gradle-original.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/icons/junit-original.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="images/icons/selenide-logo-big.png" width="50"/></a>
<a href="https://rest-assured.io/"> <img src="images/icons/restAssured.png" title="REST-assured" alt="REST-assured" width="50" height="50"/> </a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/icons/allureReports.png" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/icons/telegram.webp" width="50"/></a>
</p>

---

<a id="cases"></a>

## <a name="Тестовое покрытие">**Тестовое покрытие**</a>

### Авторизация пользователя

✅ Успешная авторизация пользователя<br>
✅ Невозможно авторизоваться без пароля<br>
✅ Пользователь не найден<br>

### Получение, редактирование, удаление пользователя

✅ Успешное получение одного пользователя <br>
✅ Проверка Заголовка при переходе на статью <br>
✅ Пользователь остутствует <br>
✅ Успешное удаление пользователя<br>

<a id="localrun"></a>

<a id="launch"></a>

## <a name="Запуск">**Запуск**</a>

```bash
 gradle clean test
```

<a id="allure"></a>

## <a name="Отчет в Allure">**Отчет в Allure**</a>

После выполнения тестов можно посмотреть отчет
в [Allure](https://jenkins.autotests.cloud/job/Reqres.in_api/8/allure/)

### На скриншоте один из результатов выполнения тестов:

<img src="images/tests/AllureReport.png" width="900">

---

<a id="allureTestOps"></a>

## <a name="Интеграция с Allure TestOps">**Интеграция с Allure TestOps**</a>

Есть интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4547/dashboards), где можно посмотреть еще
ручные тесты

<img src="images/tests/TestOps.png" width="900">

---

<a id="telegramBot"></a>

## <a name="Бот в Telegram">**Бот в Telegram**</a>

После выполнения отчета результат так же предоставит бот в Telegram:
<p align="center">
    <img src="images/tests/TelegramBot.png">
</p>

---
