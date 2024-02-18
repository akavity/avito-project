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
    public void clickButtonOrCheckbox(String title, String text) {
        log.info("Under the title: " + title + "\n click on the item contains text: " + text);
        searchFilterPage.getButtonOrCheckout(title, text).click();
    }

    @Step
    public void clickDropdownCheckbox(String title, String singText) {
        SelenideElement dropdown = searchFilterPage.getFilterField(title);
        SelenideElement checkbox = searchFilterPage.getCheckboxItem(singText);
        log.info("Click on the dropdown: " + title);
        dropdown.scrollIntoView(PARAMETER);
        dropdown.click();
        log.info("Select the checkbox: " + singText);
        actions().click(dropdown).sendKeys(checkbox).sendKeys(Keys.ESCAPE).build().perform();
    }

    @Step
    public void setValuesOfDropDownLimit(String title, String min, String max) {
        SelenideElement minValue = searchFilterPage.getValueOfMinLimit(title);
        SelenideElement maxValue = searchFilterPage.getValueOfMaxLimit(title);
        log.info("Set values of dropdown limit: " + title);
        minValue.scrollIntoView(PARAMETER);
        log.info("Set min limit: " + minValue);
        actions().click(minValue).sendKeys(min).sendKeys(Keys.ESCAPE).build().perform();
        log.info("Set max limit: " + maxValue);
        actions().click(maxValue).sendKeys(max).sendKeys(Keys.ESCAPE).build().perform();
        actions().sendKeys(Keys.DOWN);
    }

    @Step
    public void setValuesOfLimit(String title, String min, String max) {
        SelenideElement minValue = searchFilterPage.getValueOfMinLimit(title);
        SelenideElement maxValue = searchFilterPage.getValueOfMaxLimit(title);
        log.info("Set values of limit: " + title);
        minValue.scrollIntoView(PARAMETER);
        log.info("Set min limit: " + minValue);
        actions().click(minValue).sendKeys(min).build().perform();
        log.info("Set max limit: " + maxValue);
        actions().click(maxValue).sendKeys(max).build().perform();
    }

    @Step
    public void setMinValueOfLimit(String title, String min) {
        SelenideElement minValue = searchFilterPage.getValueOfMinLimit(title);
        log.info("Set min value of limit: " + title);
        minValue.scrollIntoView(PARAMETER);
        log.info("Min limit: " + minValue);
        actions().click(minValue).sendKeys(min).build().perform();
    }

    @Step
    public void setMaxValueOfLimit(String title, String max) {
        SelenideElement maxValue = searchFilterPage.getValueOfMaxLimit(title);
        log.info("Set max value of limit: " + title);
        maxValue.scrollIntoView(PARAMETER);
        log.info("Max limit: " + maxValue);
        actions().click(maxValue).sendKeys(max).build().perform();
    }

    @Step
    public void clickResultButton() {
        SelenideElement button = searchFilterPage.getResultButton();
        button.scrollIntoView(PARAMETER);
        utils.sleep(2000);
        log.info("Click result button");
        button.click();
    }
}