package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.utils.RandomUtils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static java.lang.String.format;

public class RegistrationFormWithFakerTests extends TestBase { // наследнование из класса TestBase
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker(new Locale("ru"));

    String firstName,
            lastName,
            userEmail,
            userNumber,
            day,
            month,
            year,
            currentAddress;


    @BeforeEach
    void prepareTestDate() {

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        userNumber = faker.number().numberBetween(1111111111L, 9999999999L) + "";
        day = faker.number().numberBetween(1, 30) + "";
        month = "July";
       // month = faker.;
        year = "2008";
        currentAddress = faker.address().fullAddress();
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Other")
                .setNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects("Math")
                .setHobbies("Sports")
                .uploadPicture("src/test/java/resources/ccc.png")
                .setAddress(currentAddress)
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmit();

        // String expectedFullName = firstName + lastName; // общее имя для красоты
        String expectedFullName = format("%s %s", firstName, firstName);
        String expectedDateOfBirth = format("%s %s,%s", day, month, year);
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", userEmail)
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
