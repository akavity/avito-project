package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.SearchFilterPage;
import org.akavity.utils.Utils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.actions;

@Log4j2
public class SearchFilterSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    SearchFilterPage searchFilterPage = new SearchFilterPage();
    Utils utils = new Utils();

    @Step
    public void clickCheckbox(String title, String text) {
        SelenideElement checkbox = searchFilterPage.getCheckBox(title, text);
        checkbox.scrollIntoView(PARAMETER);
        log.info("Under the title: " + title + "\n click on the checkbox: " + text);
        Dimension size = checkbox.getSize();
        actions().moveToElement(checkbox, -size.width / 2 + 2, -size.height / 2 + 2).click().perform();
    }

    @Step
    public void clickButton(String title, String text) {
        SelenideElement button = searchFilterPage.getButton(title, text);
        button.scrollIntoView(PARAMETER);
        log.info("Under the title: " + title + "\n click on the button: " + text);
        button.click();
    }

    @Step
    public void clickDropdownCheckbox(String title, String singText) {
        SelenideElement dropdown = searchFilterPage.getFilterField(title);
        SelenideElement checkbox = searchFilterPage.getCheckboxItem(singText);
        log.info("Click on the dropdown: " + title);
        dropdown.scrollIntoView(PARAMETER);
        dropdown.click();
        utils.sleep();
        log.info("Select the checkbox: " + singText);
        actions().click(dropdown).sendKeys(checkbox).sendKeys(Keys.ESCAPE).build().perform();
    }

    @Step
    public void setValuesOfDropDownLimit(String title, String min, String max) {
        SelenideElement minValue = searchFilterPage.getValueOfMinLimit(title);
        SelenideElement maxValue = searchFilterPage.getValueOfMaxLimit(title);
        if (minValue.isDisplayed()) {
            log.info("Set values of dropdown limit: " + title);
            minValue.scrollIntoView(PARAMETER);
            log.info("Set min limit: " + min);
            actions().click(minValue).sendKeys(min).sendKeys(Keys.ESCAPE).build().perform();
            log.info("Set max limit: " + max);
            actions().click(maxValue).sendKeys(max).sendKeys(Keys.ESCAPE).build().perform();
            actions().sendKeys(Keys.DOWN);
        } else {
            log.info("New car has no mileage");
        }
    }

    @Step
    public void setValuesOfDropDownLimit(String title, String max) {
        SelenideElement maxValue = searchFilterPage.getValueOfMaxLimit(title);
        log.info("Set max value of dropdown limit: " + title);
        maxValue.scrollIntoView(PARAMETER);
        log.info("Set max limit: " + max);
        actions().click(maxValue).sendKeys(max).sendKeys(Keys.ESCAPE).build().perform();
        actions().sendKeys(Keys.DOWN);
    }

    @Step
    public void setValuesOfLimit(String title, String min, String max) {
        SelenideElement minValue = searchFilterPage.getValueOfMinLimit(title);
        SelenideElement maxValue = searchFilterPage.getValueOfMaxLimit(title);
        log.info("Set values of limit: " + title);
        minValue.scrollIntoView(PARAMETER);
        log.info("Set min limit: " + min);
        actions().click(minValue).sendKeys(min).build().perform();
        log.info("Set max limit: " + max);
        actions().click(maxValue).sendKeys(max).build().perform();
        utils.sleep(1500);
    }

    @Step
    public void setMinValueOfLimit(String title, String min) {
        SelenideElement minValue = searchFilterPage.getValueOfMinLimit(title);
        log.info("Set min value of limit: " + title);
        minValue.scrollIntoView(PARAMETER);
        log.info("Min limit: " + min);
        actions().click(minValue).sendKeys(min).build().perform();
        utils.sleep(1500);
    }

    @Step
    public void setMaxValueOfLimit(String title, String max) {
        SelenideElement maxValue = searchFilterPage.getValueOfMaxLimit(title);
        log.info("Set max value of limit: " + title);
        maxValue.scrollIntoView(PARAMETER);
        log.info("Max limit: " + max);
        actions().click(maxValue).sendKeys(max).build().perform();
        utils.sleep(1500);
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
