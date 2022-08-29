package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @AfterAll
    static void closing(){
        // закрываем модалку после проверки
        $("#closeLargeModal").scrollIntoView(true).click();
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Egor")
                .setLastName("Auto")
                .setEmail("egor@mail.ru")
                .setGender("Other")
                .setNumber("89995556677") // new
                .setBirthDate("30", "July", "2008")
                .setSubjects("Math")
                .setHobbies("Sports")
                .uploadPicture("src/test/java/resources/ccc.png")
                .setAdress("Some address 1")
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Egor Auto")
                .checkResult("Student Email", "egor@mail.ru")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8999555667")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Math") // ? сравнить табл
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "ccc.png")
                .checkResult("Address", "Some address 1")
                .checkResult("State and City", "NCR Delhi");
    }
}
