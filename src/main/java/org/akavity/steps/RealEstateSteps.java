package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.RealEstatePage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Selenide.actions;

@Log4j2
public class RealEstateSteps {
    RealEstatePage realEstatePage = new RealEstatePage();
    Utils utils = new Utils();

    @Step
    public void selectTypeRealEstate(String type) {
        log.info("Type real Estate is " + type);
        realEstatePage.getRealEstateTypeButton().click();
        realEstatePage.getDropDownItem(type).click();
    }

    @Step
    public void selectBuyOrRent(String intention) {
        log.info("Your intention: " + intention);
        realEstatePage.getBuyRentButton().click();
        realEstatePage.getDropDownItem(intention).click();
    }

    @Step
    public void selectBuildTime(String type) {
        log.info("House is " + type);
        realEstatePage.getOldOrNewBuildingButton().click();
        realEstatePage.getDropDownItem(type).click();
    }

    @Step
    public void selectDropDownItem(String deskTopItem, String dropDownItem) {
        realEstatePage.getDeskTopItem(deskTopItem).click();
        realEstatePage.getDropDownItem(dropDownItem).click();
        utils.sleep(1000);
    }

    @Step
    public void selectCheckboxListItem(String deskTopItem, String checkboxListItem) {
        log.info("In  desktop " + deskTopItem + " set item: " + checkboxListItem);
        realEstatePage.getDeskTopItem(deskTopItem).click();
        realEstatePage.getCheckboxListItem(checkboxListItem).click();
    }

    @Step
    public void clickDeskTopButton(String deskTopItem) {
        realEstatePage.getDeskTopItem(deskTopItem).click();
    }

    @Step
    public void selectValuesOfLimit(String deskTopItem, String minValue, String maxValue) {
        log.info("/// Limit of " + deskTopItem);
        realEstatePage.getDeskTopItem(deskTopItem).click();
        utils.sleep(1000);
        log.info("Enter min value of limit: " + minValue);
        realEstatePage.getMinPriceInput().setValue(minValue);
        log.info("Enter max value of limit: " + maxValue);
        realEstatePage.getMaxPriceInput().setValue(maxValue);
        utils.sleep(1500);
    }

    @Step
    public void selectValuesOfDoubleSlider(String deskTopItem, int leftHandleOffset, int rightHandleOffset) {
        SelenideElement leftHandle = realEstatePage.getLeftHandle();
        SelenideElement rightHandle = realEstatePage.getRightHandle();
//        SelenideElement sliderMin = $(By.xpath("//div[contains(@class,'slider-cont')]/div[contains(@class,'slider-t')][1]/div"));
//        SelenideElement sliderMax = $(By.xpath("//div[contains(@class,'slider-cont')]/div[contains(@class,'slider-t')][2]/div"));
        log.info("/// Slider of " + deskTopItem);
        realEstatePage.getDeskTopItem(deskTopItem).click();
        utils.sleep(1000);
        actions().dragAndDropBy(leftHandle, leftHandleOffset, 0).build().perform();
        log.info("Drag left handle to " + leftHandleOffset);
        utils.sleep(1000);
        actions().dragAndDropBy(rightHandle, rightHandleOffset, 0).build().perform();
        log.info("Drag right handle to " + rightHandleOffset);
        utils.sleep(1000);
    }

    @Step
    public void clickShowResultButton() {
        log.info("Click show resul button");
        realEstatePage.getShowResultButton().click();
        utils.sleep(1500);
    }
}
