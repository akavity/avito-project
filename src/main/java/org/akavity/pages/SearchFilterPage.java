package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchFilterPage {
    private final SelenideElement resultButton = $(By.xpath("//button[contains(@class,'button-button')]/.."));

    public SelenideElement getButtonOrCheckout(String title, String text) {
        return $(By.xpath("//div[starts-with(@class,'fieldset')]//span[contains(text(),'" + title + "')]" +
                "/../../following-sibling::div//span[contains (text(),'" + text + "')]/../.."));
    }

    //div[starts-with(@class,'fieldset')]//span[contains(@class,'text-bold') and contains(text(),'')] title  28
    //div[starts-with(@class,'fieldset')]//span[contains(text(),'" + title + "')]   use it )

    public SelenideElement getFilterField(String title) {
        return $(By.xpath("//div[starts-with(@class,'fieldset')]//span[contains(text(),'" + title + "')]" +
                "/../../following-sibling::div"));
    }

    public SelenideElement getCheckboxItem(String name) {
        return $(By.xpath("//div[@role='button']/p[contains(text(),'" + name + "')]/../.."));
    }

    public SelenideElement getValueOfMinLimit(String title) {
        return $(By.xpath("//span[contains(text(),'" + title + "')]" +
                "/../../following-sibling::div//input[contains(@data-marker,'from')]"));
    }

    public SelenideElement getValueOfMaxLimit(String title) {
        return $(By.xpath("//span[contains(text(),'" + title + "')]" +
                "/../../following-sibling::div//input[contains(@data-marker,'to')]"));
    }

    public SelenideElement getResultButton() {
        return resultButton;
    }
}
