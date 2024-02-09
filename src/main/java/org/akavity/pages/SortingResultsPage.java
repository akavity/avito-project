package org.akavity.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class SortingResultsPage {
    private final ElementsCollection searchingResults = $$(By.cssSelector("div[itemtype*='http://schema.org/Product']"));
    public ElementsCollection getSearchingResults() {
        return searchingResults;
    }
}
