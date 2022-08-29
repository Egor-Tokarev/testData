package com.demoqa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HobbiesComponent {

    public HobbiesComponent setHobie(String hobbie){
        $("#hobbiesWrapper").$(byText(hobbie)).click();
        return this;
    }
}

