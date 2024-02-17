package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.SearchFilterPage;
import org.akavity.utils.Utils;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.actions;

@Log4j2
public class SearchFilterSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    SearchFilterPage searchFilterPage = new SearchFilterPage();
    Utils utils = new Utils();

    @Step
    public void clickFilterButtonOrCheckout(String title, String text) {
        log.info("Under the title: " + title + "\n click on the item contains text: " + text);
        searchFilterPage.getFilterButtonAndCheckout(title, text).click();
    }

    @Step
    public void clickCheckboxItem(String title, String itemName) {
        log.info("Click on the field under the title: " + title);
        SelenideElement checkbox = searchFilterPage.getFilterField(title);
        SelenideElement checkout = searchFilterPage.getCheckboxItem(itemName);
        checkbox.scrollIntoView(PARAMETER);
        checkbox.click();
        actions().click(checkbox).sendKeys(checkout).sendKeys(Keys.ESCAPE).build().perform();
    }

    @Step
    public void setValuesOfLimit(String title, String min, String max) {
        log.info("Set values of limit: " + title);
        SelenideElement minValue = searchFilterPage.getValueOfMinLimit(title);
        SelenideElement maxValue = searchFilterPage.getValueOfMaxLimit(title);
        log.info("Set min limit: " + minValue);
        minValue.scrollIntoView(PARAMETER).setValue(min);
        utils.sleep(1000);
        log.info("Set max limit: " + maxValue);
        maxValue.setValue(max);
    }

    @Step
    public void setMinValueOfLimit(String title, String min) {
        log.info("Set values of limit: " + title);
        SelenideElement minValue = searchFilterPage.getValueOfMinLimit(title);
        log.info("Set min limit: " + minValue);
        minValue.scrollIntoView(PARAMETER).setValue(min);
    }

    @Step
    public void setMaxValueOfLimit(String title, String max) {
        log.info("Set values of limit: " + title);
        SelenideElement maxValue = searchFilterPage.getValueOfMaxLimit(title);
        log.info("Set max limit: " + maxValue);
        maxValue.scrollIntoView(PARAMETER).setValue(max);
    }

    @Step
    public void setValuesOfDropDownLimit(String title, String min, String max) {
        SelenideElement minValue = searchFilterPage.getValueOfMinLimit(title);
        SelenideElement maxValue = searchFilterPage.getValueOfMaxLimit(title);
        minValue.scrollIntoView(PARAMETER);
//        minValue.sendKeys(min);
//        minValue.sendKeys(Keys.RETURN);
//        utils.sleep(1000);
//        maxValue.sendKeys(max);
//        maxValue.sendKeys(Keys.ESCAPE);
        actions().click(minValue).sendKeys(min).sendKeys(Keys.ESCAPE).build().perform();
////        minValue.setValue(min);
//        utils.sleep(700);
//        maxValue.setValue(max);
        actions().click(maxValue).sendKeys(max).sendKeys(Keys.ESCAPE).build().perform();
        actions().sendKeys(Keys.DOWN);
    }
}
