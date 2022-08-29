package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectsComponent {

    public SubjectsComponent setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }
}

