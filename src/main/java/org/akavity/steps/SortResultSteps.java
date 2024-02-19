package org.akavity.steps;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.SortResultPage;
import org.akavity.utils.Utils;

import java.util.ArrayList;
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
    public int getPriceFirstFoundObject() {
        String price = sortResultPage.getPricesOfFoundObjects().first().getText();
        log.info("Found price of first object: " + price);
        return Integer.parseInt(price
                .replace(" ", "")
                .replace("₽", ""));
    }

    @Step
    public String getNameOfFirstFoundObject() {
        String name = sortResultPage.getFoundObjectsTitles().first().getText();
        log.info("The name of the found object: " + name);
        return name;
    }

    @Step
    public boolean eachArrayElementContainsText(String text, int elements) {
        boolean result = true;
        List<String> names = new ArrayList<>(sortResultPage.getFoundObjectsTitles().first(elements).texts());
        for (String name : names) {
            log.info("Array names contains name: " + name);
            if (!name.contains(text)) {
                log.info("/// Object name dose not contain text: " + text);
                result = false;
                break;
            }
        }
        return result;
    }

    @Step
    public boolean doTitlesContainSpecificName(String name, int elements) {
       return utils.doElementsContainText(sortResultPage.getFoundObjectsTitles(), name, elements);
    }

    @Step
    public boolean doDescriptionsContainText(String text, int elements) {
        return utils.doElementsContainText(sortResultPage.getShortDescriptionField(), text, elements);
    }
}
