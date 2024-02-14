package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.AllCarData;
import org.akavity.models.PopularCarData;
import org.akavity.steps.MainSteps;
import org.akavity.steps.RubricatorSteps;
import org.akavity.steps.SortResultSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoTest extends BaseTest {
    MainSteps mainSteps = new MainSteps();
    RubricatorSteps rubricatorSteps = new RubricatorSteps();
    SortResultSteps sortResultSteps = new SortResultSteps();

    @TestData(jsonFile = "allCarData", model = "AllCarData")
    @Test(description = "Check the sorting when searching for a car",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectPopularCarModel(AllCarData carData) {
        mainSteps.moveToSection(carData.getSection());
        rubricatorSteps.clickAllItemsButton();
        rubricatorSteps.clickRubricatorItem(carData.getCarBrand());
        rubricatorSteps.clickRubricatorItem(carData.getCarModel());

        Assert.assertTrue(sortResultSteps.eachArrayElementContainsText(carData.getFullCarName(), carData.getNumberOfArrayElements()));
    }

    @TestData(jsonFile = "popularCarData", model = "PopularCarData")
    @Test(description = "Check the sorting when searching for a popular car",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectPopularCarModel(PopularCarData carData) {
        mainSteps.moveToSection(carData.getSection());
        rubricatorSteps.clickRubricatorItem(carData.getCarBrand());
        rubricatorSteps.clickRubricatorItem(carData.getCarModel());

        Assert.assertTrue(sortResultSteps.eachArrayElementContainsText(carData.getFullCarName(), carData.getNumberOfArrayElements()));
    }
}
