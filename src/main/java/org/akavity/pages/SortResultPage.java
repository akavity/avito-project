package org.akavity.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class SortResultPage {
    private final ElementsCollection foundObjects = $$(By.cssSelector("div[itemtype*='http://schema.org/Product']"));
    private final ElementsCollection foundObjectsTitles = $$(By.cssSelector("h3[itemprop='name']"));
    private final ElementsCollection pricesOfFoundObjects = $$(By.cssSelector("strong[class*='styles-module-root'] span"));
    private final ElementsCollection shortDescriptionField = $$(By.cssSelector("p[data-marker*='specific-params']"));

    public ElementsCollection getFoundObjects() {
        return foundObjects;
    }

    public ElementsCollection getFoundObjectsTitles() {
        return foundObjectsTitles;
    }

    public ElementsCollection getPricesOfFoundObjects() {
        return pricesOfFoundObjects;
    }

    public ElementsCollection getShortDescriptionField() {
        return shortDescriptionField;
    }
}
