package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavigationPage {
    public SelenideElement getNavigationItem(String itemName) {
        return $(By.xpath("//div[contains(@class,'outer')]//a[contains(@data-marker,'" + itemName + "')]"));
    }

    public SelenideElement getRecommendationItem() {
        return $(By.xpath("//div[contains(@data-marker,'recommendations')]"));
    }
}
