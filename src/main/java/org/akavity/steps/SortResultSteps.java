package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.SortResultPage;

@Log4j2
public class SortResultSteps {
    SortResultPage sortResultPage = new SortResultPage();

    @Step
    public void clickFirstFoundObjects() {
        log.info("Click first found object");
        sortResultPage.getFoundObjects().first().click();
    }

    @Step
    public int getPriceFirstFoundObject() {
        String price = sortResultPage.getPricesOfFoundObjects().first().getText();
        log.info("Found price of first object: " + price);
        return Integer.parseInt(price
                .replace(" ", "")
                .replace("₽", ""));
    }
}
