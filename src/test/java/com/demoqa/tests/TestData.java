package com.demoqa.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

   static Faker faker = new Faker(new Locale("de"));
   public static String
           firstName = faker.name().firstName(),
           lastName = faker.name().lastName(),
           userEmail = faker.internet().emailAddress(),
           gender = "Other",
           userNumber = faker.number().numberBetween(1111111111L, 9999999999L) + "",
           day = faker.number().numberBetween(1, 28) + "",
           month = "July",
           year = faker.number().numberBetween(2000, 2001) + "",
           currentAddress = faker.address().fullAddress(),
           subjects = "Math",
           hobbies = "Sports",
           state = "NCR",
           city = "Delhi";
}
