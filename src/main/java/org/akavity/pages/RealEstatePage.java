package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RealEstatePage {
    private final SelenideElement realEstateTypeButton = $(By.xpath("//input[@value='Квартира']/../.."));
    private final SelenideElement buyRentButton = $(By.xpath("//input[@value='Купить']/../.."));
    private final SelenideElement oldNewButton = $(By.xpath("//input[@value='Вторичка, новостройки']/../.."));

    public final SelenideElement dropDownItem(String item) {
        return $(By.xpath("//div[contains(@class,'dropdown-list')]//span[contains(text(),'" + item + "')]"));
    }

    public SelenideElement getRealEstateTypeButton() {
        return realEstateTypeButton;
    }

    public SelenideElement getBuyRentButton() {
        return buyRentButton;
    }

    public SelenideElement getOldNewButton() {
        return oldNewButton;
    }
}
