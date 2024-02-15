package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.autoTest.SpecialEquipmentData;
import org.akavity.models.autoTest.CarData;
import org.akavity.steps.RubricatorSteps;
import org.akavity.steps.SortResultSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoTest extends BaseTest {
    RubricatorSteps rubricatorSteps = new RubricatorSteps();
    SortResultSteps sortResultSteps = new SortResultSteps();

    @TestData(jsonFile = "carData", model = "CarData", folder = "autoTest")
    @Test(description = "Check the sorting when searching for a car",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectCarModel(CarData carData) {
        rubricatorSteps.moveToSection(carData.getSection());
        rubricatorSteps.clickAllItemsButton(carData.getDecision());
        rubricatorSteps.clickRubricatorItem(carData.getCarBrand());
        rubricatorSteps.clickRubricatorItem(carData.getCarModel());

        String fullCarName = carData.getFullCarName();
        int numberOfSortResult = carData.getNumberOfArrayElements();

        Assert.assertTrue(sortResultSteps.eachArrayElementContainsText(fullCarName, numberOfSortResult));
    }

    @TestData(jsonFile = "specialEquipmentData", model = "SpecialEquipmentData", folder = "autoTest")
    @Test(description = "Check the sorting when searching for a special equipment",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectTrucksAndSpecialEquipment(SpecialEquipmentData equipment) {
        rubricatorSteps.moveToSection(equipment.getFirstSection());
        rubricatorSteps.moveToSection(equipment.getSecondSection());
        rubricatorSteps.moveToSection(equipment.getThirdSection());
        rubricatorSteps.clickAllItemsButton(equipment.getFirstDecision());
        rubricatorSteps.clickRubricatorItem(equipment.getTypeOfEquipment());
        rubricatorSteps.clickAllItemsButton(equipment.getSecondDecision());
        rubricatorSteps.clickRubricatorItem(equipment.getEquipmentBrand());
        rubricatorSteps.clickRubricatorItem(equipment.getEquipmentModel());

        Assert.assertTrue(sortResultSteps.eachArrayElementContainsText(equipment.getFullEquipmentName(),
                equipment.getNumberOfArrayElements()));
    }
}
