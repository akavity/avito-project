package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RealEstatePage {
    private final SelenideElement realEstateTypeButton = $(By.xpath("//input[@value='Квартира']/../.."));
    private final SelenideElement buyRentButton = $(By.xpath("//input[@value='Купить']/../.."));
    private final SelenideElement oldOrNewBuildingButton = $(By.xpath("//input[@value='Вторичка, новостройки']/../.."));
    private final SelenideElement showResultButton = $(By.cssSelector("a[data-marker*='button-0'] span[class*='desktop']"));
    private final SelenideElement minPriceInput = $(By.cssSelector("input[data-marker*='from']"));
    private final SelenideElement maxPriceInput = $(By.cssSelector("input[data-marker*='to']"));
    private final SelenideElement leftHandle = $(By.xpath("//div[contains(@class,'slider-cont')]" +
            "/div[contains(@class,'slider-t')][1]/div"));
    private final SelenideElement rightHandle = $(By.xpath("//div[contains(@class,'slider-cont')]" +
            "/div[contains(@class,'slider-t')][2]/div"));

    public SelenideElement getDeskTopItem(String item) {
        return $(By.xpath("//div[contains(@class,'desktop')]//span[contains(text(),'" + item + "')]/../.. " +
                "| //div[contains(@class,'desktop')]//input[contains(@value,'" + item + "')]/../.."));
    }

    public SelenideElement paramButton(String param) {
        return $(By.xpath("//span[contains(@class,'tooltip')]//span[contains(text(),'" + param + "') " +
                "and contains(@class,'styles')]"));
    }

    public SelenideElement getDropDownItem(String item) {
        return $(By.xpath("//div[contains(@class,'dropdown-list')]//span[contains(text(),'" + item + "')]"));
    }

    public SelenideElement getCheckboxListItem(String item) {
        return $(By.xpath("//span[contains(@class,'desktop')]/span[contains(text(),'" + item + "')]"));
    }

    public SelenideElement getMinPriceInput() {
        return minPriceInput;
    }

    public SelenideElement getMaxPriceInput() {
        return maxPriceInput;
    }

    public SelenideElement getRealEstateTypeButton() {
        return realEstateTypeButton;
    }

    public SelenideElement getBuyRentButton() {
        return buyRentButton;
    }

    public SelenideElement getOldOrNewBuildingButton() {
        return oldOrNewBuildingButton;
    }

    public SelenideElement getShowResultButton() {
        return showResultButton;
    }

    public SelenideElement getLeftHandle() {
        return leftHandle;
    }

    public SelenideElement getRightHandle() {
        return rightHandle;
    }
}
