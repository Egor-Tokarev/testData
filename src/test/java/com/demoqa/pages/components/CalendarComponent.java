package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    public CalendarComponent setDate (String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }

}



        app_settings=eyJhZ3JlZW1lbnRzIjoiMTExIiwicHJvbW8iOiIxMTEiLCJ2a2NfYmVoYXZpb3IiOiIiLCJ2a2NfYXV0aF9hY3Rpb24iOiIiLCJ2a2NfYnJhbmQiOiIiLCJ2a2NfZGlzcGxheV9tb2RlIjoiIn0%3D

        app_settings=eyJhZ3JlZW1lbnRzIjoiMTExIiwicHJvbW8iOiIxMTEiLCJ2a2NfYmVoYXZpb3IiOiIiLCJ2a2NfYXV0aF9hY3Rpb24iOiIiLCJ2a2NfYnJhbmQiOiIiLCJ2a2NfZGlzcGxheV9tb2RlIjoiIn0%3D

https://id.vk.com/auth?app_id=7303035&v=1.54.0&redirect_uri=https%3A%2F%2Fdemo.vksak.com&uuid=kvXEuEgVjNvaqbNcnjLKy&scheme=bright_light&app_settings=eyJhZ3JlZW1lbnRzIjoiMTExIiwicHJvbW8iOiIxMTEiLCJ2a2NfYmVoYXZpb3IiOiIiLCJ2a2NfYXV0aF9hY3Rpb24iOiIiLCJ2a2NfYnJhbmQiOiIiLCJ2a2NfZGlzcGxheV9tb2RlIjoiIn0%3D