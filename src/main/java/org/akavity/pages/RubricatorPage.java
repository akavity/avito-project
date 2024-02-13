package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RubricatorPage {
    private final SelenideElement popularItemsButton = $(By.xpath("//button[contains(@class,'popular')]"));
    private final SelenideElement allItemsButton =
            $(By.xpath("//button[contains(@class,'popular')]/following-sibling::span"));

    public SelenideElement getRubricatorItem(String carModel) {
        return $(By.cssSelector("div[data-marker='popular-rubricator/links'] a[title='" + carModel + "']"));
    }

    public SelenideElement getPopularItemsButton() {
        return popularItemsButton;
    }

    public SelenideElement getAllItemsButton() {
        return allItemsButton;
    }
}
