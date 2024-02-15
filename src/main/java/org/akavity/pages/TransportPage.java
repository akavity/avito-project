package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TransportPage {
    public SelenideElement getAutoTypeItem(String type) {
        return $(By.xpath("//div[contains(@class,'outer')]//a[contains(@data-marker,'" + type + "')]"));
    }

    public SelenideElement getServiceItem(String title) {
        return $(By.xpath("//div[@data-marker='rubricator-widget']//div[contains(text(),'" + title + "')]"));
    }

    public SelenideElement getAutoRecommendationItem(String autoBrand) {
        return $(By.xpath("//div[not(contains(@data-marker,'hidde'))]/div/a[contains(text(),'" + autoBrand + "')]"));
    }

    public SelenideElement getAutoImage(String autoBrand) {
        return $(By.xpath("//div[contains(@data-marker,'image-l')]//img[@alt='" + autoBrand + "']"));
    }
}
