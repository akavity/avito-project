package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.CarData;
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

    @TestData(jsonFile = "carData", model = "CarData")
    @Test(description = "Check the sorting when searching for a car",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectCarModel(CarData carData) {
        mainSteps.moveToSection(carData.getSection());
        rubricatorSteps.clickAllItemsButton(carData.getDecision());
        rubricatorSteps.clickRubricatorItem(carData.getCarBrand());
        rubricatorSteps.clickRubricatorItem(carData.getCarModel());

        Assert.assertTrue(sortResultSteps.eachArrayElementContainsText(carData.getFullCarName(), carData.getNumberOfArrayElements()));
    }
}
