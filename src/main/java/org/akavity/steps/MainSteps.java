package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.MainPage;

import static com.codeborne.selenide.Selenide.executeJavaScript;
@Log4j2
public class MainSteps {
    MainPage mainPage = new MainPage();

    @Step
    public void moveToSection(String title) {
        SelenideElement element = mainPage.getNavigationItem(title);
        log.info("Move to section: " + title);
        executeJavaScript("arguments[0].click();", element);
    }
}
