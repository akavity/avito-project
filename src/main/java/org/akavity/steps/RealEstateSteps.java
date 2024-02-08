package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.RealEstatePage;

@Log4j2
public class RealEstateSteps {
    RealEstatePage realEstatePage = new RealEstatePage();

    @Step
    public void selectTypeRealEstate(String type) {
        realEstatePage.getRealEstateTypeButton().click();
        realEstatePage.dropDownItem(type).click();
    }

    @Step
    public void selectBuyOrRent(String intention) {
        realEstatePage.getBuyRentButton().click();
        realEstatePage.dropDownItem(intention).click();
    }

    @Step
    public void selectBuildTime(String type) {
        realEstatePage.getOldNewButton().click();
        realEstatePage.dropDownItem(type).click();
    }
}
