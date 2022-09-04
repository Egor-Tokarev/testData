package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.utils.RandomUtils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static java.lang.String.format;

public class RegistrationFormWithFakerTests extends TestBase { // наследование из класса TestBase
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(TestData.firstName)
                .setLastName(TestData.lastName)
                .setEmail(TestData.userEmail)
                .setGender(TestData.gender)
                .setNumber(TestData.userNumber)
                .setBirthDate(TestData.day, TestData.month, TestData.year)
                .setSubjects(TestData.subjects)
                .setHobbies(TestData.hobbies) // сделать рандом из 3 на выбор
                .uploadPicture("src/test/java/resources/ccc.png")
                .setAddress(TestData.currentAddress)
                .setState(TestData.state)
                .setCity(TestData.city)
                .pressSubmit();

        String expectedFullName = TestData.firstName + " " + TestData.lastName; // общее имя для красоты
        // String expectedFullName = format("%s %s", TestData.firstName, TestData.firstName);
        String expectedDateOfBirth = format("%s %s,%s", TestData.day, TestData.month, TestData.year);
        String expectedFullCity = format("%s %s", TestData.state, TestData.city);
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", TestData.userEmail)
                .checkResult("Gender", TestData.gender)
                .checkResult("Mobile", TestData.userNumber)
                .checkResult("Date of Birth", expectedDateOfBirth)
                .checkResult("Subjects", TestData.subjects)
                .checkResult("Hobbies", TestData.hobbies)
                .checkResult("Picture", "ccc.png")
                .checkResult("Address", TestData.currentAddress)
                .checkResult("State and City", expectedFullCity);
    }
}
