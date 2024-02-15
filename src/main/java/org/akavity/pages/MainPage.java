package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement getRecommendationItem() {
        return $(By.xpath("//div[contains(@data-marker,'recommendations')]"));
    }
}
