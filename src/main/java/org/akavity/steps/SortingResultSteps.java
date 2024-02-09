package org.akavity.steps;

import io.qameta.allure.Step;
import org.akavity.pages.SortingResultsPage;

public class SortingResultSteps {
    SortingResultsPage sortingResultsPage = new SortingResultsPage();

    @Step
    public void clickFirstSortingResult() {
        sortingResultsPage.getSearchingResults().first().click();
    }
}

