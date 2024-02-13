package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.RubricatorPage;

@Log4j2
public class RubricatorSteps {
    RubricatorPage rubricatorPage = new RubricatorPage();

    @Step
    public void clickRubricatorItem(String item) {
        log.info("Click on the car brand: " + item);
        rubricatorPage.getRubricatorItem(item).click();
    }

    @Step
    public void clickAllItemsButton() {
        log.info("Click all items button");
        rubricatorPage.getAllItemsButton().click();
    }

    @Step
    public void clickPopularItemsButton() {
        log.info("Click popular items button");
        rubricatorPage.getPopularItemsButton().click();
    }
}
