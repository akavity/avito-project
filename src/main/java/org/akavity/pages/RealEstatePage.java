package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RealEstatePage {

    private final SelenideElement realEstateTypeButton = $(By.xpath("//input[@value='Квартира']/../.."));
    private final SelenideElement buyRentButton = $(By.xpath("//input[@value='Купить']/../.."));
    private final SelenideElement oldNewButton = $(By.xpath("//input[@value='Вторичка, новостройки']/../.."));

    public SelenideElement deskTopItem(String item) {
        return $(By.xpath(" //div[contains(@class,'desktop')]//input[contains(@value,'" + item + "')]/../.."));
    }
    //div[contains(@class,'desktop')]//input[contains(@value,'')]/../..     all deskTop items )))
    public SelenideElement paramButton(String param) {
        return $(By.xpath("//span[contains(@class,'tooltip')]//span[contains(text(),'" + param + "') and contains(@class,'styles')]"));
    }

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
