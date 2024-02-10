package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ObjectOfSalePage {
    private final SelenideElement priceField = $(By.cssSelector("div[class*='item-price'] span[itemprop='price']"));
    private final SelenideElement numberOfRoomsField = $(By.xpath("//span[contains(text(),'во комнат')]/.."));
    private final SelenideElement totalAreaField = $(By.xpath("//span[contains(text(),'Общая площадь')]/.."));

    public SelenideElement getPriceField() {
        return priceField;
    }

    public SelenideElement getNumberOfRoomsField() {
        return numberOfRoomsField;
    }

    public SelenideElement getTotalAreaField() {
        return totalAreaField;
    }
}
