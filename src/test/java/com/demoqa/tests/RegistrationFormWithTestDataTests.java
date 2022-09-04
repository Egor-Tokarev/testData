package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.demoqa.tests.TestData.*;
import static java.lang.String.format;

public class RegistrationFormWithTestDataTests extends TestBase { // наследнование из класса TestBase
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail("egor@mail.ru")
                .setGender("Other")
                .setNumber("89995556677")
                .setBirthDate(day, month, year)
                .setSubjects("Math")
                .setHobbies("Sports")
                .uploadPicture("src/test/java/resources/ccc.png")
                .setAddress("Some address 1")
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmit();

        // String expectedFullName = firstName + lastName; // общее имя для красоты
        String expectedFullName = format("%s %s", firstName, firstName);
        String expectedDateOfBirth = format("%s %s,%s", day, month, year);
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", "egor@mail.ru")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8999555667")
                .checkResult("Date of Birth", expectedDateOfBirth)
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "ccc.png")
                .checkResult("Address", "Some address 1")
                .checkResult("State and City", "NCR Delhi");
    }

}
