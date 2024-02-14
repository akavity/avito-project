package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RubricatorPage {
    private final SelenideElement popularItemsButton = $(By.cssSelector("div[data-marker*='controls'] span[class*='popular']"));
    private final SelenideElement allItemsButton = $(By.cssSelector("button[class*='popular']"));

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
