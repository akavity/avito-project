package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.RubricatorPage;

import static com.codeborne.selenide.Selenide.executeJavaScript;

@Log4j2
public class RubricatorSteps {
    RubricatorPage rubricatorPage = new RubricatorPage();

    @Step
    public void clickRubricatorItem(String item) {
        log.info("Click on the rubricator item: " + item);
        rubricatorPage.getRubricatorItem(item).click();
    }

    @Step
    public void clickAllItemsButton() {
        log.info("Click all items button");
        rubricatorPage.getAllItemsButton().click();
    }

    @Step
    public void clickAllItemsButton(String decision) {
        switch (decision) {
            case "yes" -> {
                log.info("Click all items button");
                rubricatorPage.getAllItemsButton().click();
            }
            case "no" -> log.info("Watch popular items");
            default -> log.info("Not correct decision. Please select yes, no");
        }
    }

    @Step
    public void clickPopularItemsButton() {
        log.info("Click popular items button");
        rubricatorPage.getPopularItemsButton().click();
    }

    //    Visual Rubricaror

    @Step
    public void moveToSection(String title) {
        SelenideElement element = rubricatorPage.getVisualRubricarorItem(title);
        log.info("Move to section: " + title);
        executeJavaScript("arguments[0].click();", element);
    }
}
