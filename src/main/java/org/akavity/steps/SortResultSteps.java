package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.SortResultPage;
import org.akavity.utils.Utils;

import java.util.List;

@Log4j2
public class SortResultSteps {
    SortResultPage sortResultPage = new SortResultPage();
    Utils utils = new Utils();

    @Step
    public void clickFirstFoundObjects() {
        log.info("Click first found object");
        sortResultPage.getFoundObjects().first().click();
    }

    @Step
    public String getNameOfFirstFoundObject() {
        String name = sortResultPage.getFoundObjectsTitles().first().getText();
        log.info("The name of the found object: " + name);
        return name;
    }

    @Step
    public int getPriceFirstFoundObject() {
        String price = sortResultPage.getPricesOfFoundObjects().first().getText();
        log.info("Found price of first object: " + price);
        return utils.extractIntFromText(price, "\\d+[ ]?\\d+[ ]?\\d+");
    }

    @Step
    public boolean doTitlesContainSpecificName(String name, int elements) {
        return utils.doElementsContainText(sortResultPage.getFoundObjectsTitles(), name, elements);
    }

    @Step
    public boolean doDescriptionsContainText(List<String> parameters, int elements) {
        return utils.doShortDescriptionsContainText(sortResultPage.getShortDescriptionField(), parameters, elements);
    }
}
