package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal  resultsModal = new ResultsModal();

    //Elements
    private SelenideElement
            firstNameInput = $("#firstName"), // переменная имени
            lastNameInput = $("#lastName"), // переменная фамилии
            emailInput = $("#userEmail"), // переменная email
            numberInput = $("#userNumber"),
            subInput = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            adressInput =  $("#currentAddress");

    private final static String TITLE_TEXT = "Student Registration Form";

    //Actions
    // Открытие страницы, проверка наличия названия, удаление футера и др
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    // имя
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    // очистка имени
    public RegistrationFormPage clearFirstName(String value) {
        firstNameInput.clear();
        return this;
    }
    // фамилия
    public RegistrationFormPage setLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }
    // email
    public RegistrationFormPage setEmail (String value) {
        emailInput.setValue(value);
        return this;
}
    // выбор пола
    public RegistrationFormPage setGender (String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }
    // номер телефона
    public RegistrationFormPage setNumber (String value) {
        numberInput.setValue(value); // ?
        return this;
    }
    // др
    public RegistrationFormPage setBirthDate (String day, String month,  String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    // subject
    public RegistrationFormPage setSubjects(String value) {
        subInput.setValue(value).pressEnter();
        return this;
    }
    // хобби
    public RegistrationFormPage setHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }

    // папку с файлом создать в resourses и указать путь
    public RegistrationFormPage uploadPicture(String value) {
        //picture.uploadFromClasspath("img/1.png");
        picture.uploadFile(new File("src/test/java/resources/ccc.png"));

        return this;
    }
    // адрес
    public RegistrationFormPage setAdress(String value) {
        adressInput.setValue(value);
        return this;
    }
    // выбор штата
    public RegistrationFormPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        return this;
    }
    // выбор города
    public RegistrationFormPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        return this;
    }
    // кнопка
    public RegistrationFormPage pressSubmit() {
        $("#submit").click();
        return this;
    }

    // проверка видимости таблицы
    public RegistrationFormPage checkResultsTableVisible () {
        resultsModal.checkVisible();
        return this;
    }
    // проверка результатов
    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);
        return this;
    }
}

