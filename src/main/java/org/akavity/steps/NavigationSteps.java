package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.akavity.pages.NavigationPage;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class NavigationSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    NavigationPage navigationPage = new NavigationPage();

    @Step
    public void moveToSection(String title) {
        SelenideElement element = navigationPage.getNavigationItem(title);
        executeJavaScript("arguments[0].click();", element);
//        actions().moveToElement(element);
//        actions().click(element).build().perform();
    }
}
