package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static java.lang.String.format;

public class RegistrationFormWithRandomUtilsTests extends TestBase { // наследнование из класса TestBase
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String firstName,
            lastName,
            userEmail,
            userNumber,
            day,
            month,
            year;


    @BeforeEach
    void prepareTestDate() {
        //    firstName = RandomUtils.getRandomString1(10);
        firstName = RandomUtils.getRandomString(10);
        lastName = RandomUtils.getRandomString(10);
        userEmail = RandomUtils.getRandomEmail();
        userNumber = RandomUtils.getRandomPhone();
        day = "30";
        month = "July";
        year = "2008";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
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
