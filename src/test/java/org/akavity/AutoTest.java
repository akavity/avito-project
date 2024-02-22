package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.autoTest.*;
import org.akavity.steps.RubricatorSteps;
import org.akavity.steps.SearchFilterSteps;
import org.akavity.steps.SortResultSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AutoTest extends MainTest {
    RubricatorSteps rubricatorSteps = new RubricatorSteps();
    SortResultSteps sortResultSteps = new SortResultSteps();
    SearchFilterSteps searchFilterSteps = new SearchFilterSteps();

    @TestData(jsonFile = "carData", model = "CarData", folder = "autoTest")
    @Test(description = "Check the sorting when searching for a car",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectCarModelUsingRubricator(CarData carData) {
        rubricatorSteps.moveToSection(carData.getSection());
        rubricatorSteps.clickAllItemsButton(carData.getDecision());
        rubricatorSteps.clickRubricatorItem(carData.getCarBrand());
        rubricatorSteps.clickRubricatorItem(carData.getCarModel());

        String fullCarName = carData.getFullCarName();
        int numberOfSortResults = carData.getNumberOfArrayElements();
        Assert.assertTrue(sortResultSteps.doTitlesContainSpecificName(fullCarName, numberOfSortResults));
    }

    @TestData(jsonFile = "specialEquipmentData", model = "SpecialEquipmentData", folder = "autoTest")
    @Test(description = "Check the sorting when searching for a special equipment",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectSpecialEquipmentUsingRubricator(SpecialEquipmentData equipment) {
        rubricatorSteps.moveToSection(equipment.getFirstSection());
        rubricatorSteps.moveToSection(equipment.getSecondSection());
        rubricatorSteps.moveToSection(equipment.getThirdSection());
        rubricatorSteps.clickAllItemsButton(equipment.getFirstDecision());
        rubricatorSteps.clickRubricatorItem(equipment.getTypeOfEquipment());
        rubricatorSteps.clickAllItemsButton(equipment.getSecondDecision());
        rubricatorSteps.clickRubricatorItem(equipment.getEquipmentBrand());
        rubricatorSteps.clickRubricatorItem(equipment.getEquipmentModel());

        String fullCarName = equipment.getFullEquipmentName();
        int numberOfSortResults = equipment.getNumberOfArrayElements();
        Assert.assertTrue(sortResultSteps.doTitlesContainSpecificName(fullCarName, numberOfSortResults));
    }

    @TestData(jsonFile = "truckData", model = "TruckData", folder = "autoTest")
    @Test(description = "Check the sorting when searching for a truck",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectTruckUsingRubricator(TruckData truck) {
        rubricatorSteps.moveToSection(truck.getFirstSection());
        rubricatorSteps.moveToSection(truck.getSecondSection());
        rubricatorSteps.moveToSection(truck.getThirdSection());
        rubricatorSteps.clickAllItemsButton(truck.getDecision());
        rubricatorSteps.clickRubricatorItem(truck.getTruckBrand());
        rubricatorSteps.clickRubricatorItem(truck.getTruckModel());
        rubricatorSteps.clickRubricatorItem(truck.getWheelFormula());

        String fullCarName = truck.getFullEquipmentName();
        int numberOfSortResults = truck.getNumberOfArrayElements();
        Assert.assertTrue(sortResultSteps.doTitlesContainSpecificName(fullCarName, numberOfSortResults));
    }

    @TestData(jsonFile = "carFilterData", model = "CarFilterData", folder = "autoTest")
    @Test(description = "Select car using filters: type car, car brand, car model, min and max price, " +
            "min and max car mileage, drive unit",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectCarUsingFiltersTest1(CarFilterData car) {
        rubricatorSteps.moveToSection(car.getSectionFirst());
        rubricatorSteps.moveToSection(car.getSectionSecond());
        searchFilterSteps.clickButtonOrCheckbox(car.getTypeCarTitle(), car.getTypeCar());
        searchFilterSteps.clickDropdownCheckbox(car.getCarBrandTitle(), car.getCarBrand());
        searchFilterSteps.clickDropdownCheckbox(car.getCarModelTitle(), car.getCarModel());
        searchFilterSteps.setValuesOfLimit(car.getPriceTitle(), car.getMinPrice(), car.getMaxPrice());
        searchFilterSteps.setValuesOfDropDownLimit(car.getCarMileageTitle(), car.getMinCarMileage(), car.getMaxCarMileage());
        searchFilterSteps.clickButtonOrCheckbox(car.getDriveUnitTitle(), car.getDriveUnit());
        searchFilterSteps.clickResultButton();

        int actual = sortResultSteps.getPriceFirstFoundObject();
        int minPrice = Integer.parseInt(car.getMinPrice());
        int maxPrice = Integer.parseInt(car.getMaxPrice());

        Assert.assertTrue(actual <= maxPrice && actual >= minPrice);
        Assert.assertTrue(sortResultSteps.doTitlesContainSpecificName(car.getFullCarName(), car.getNumberOfArrayElements()));
    }

    @TestData(jsonFile = "carFilterTwoData", model = "CarFilterTwoData", folder = "autoTest")
    @Test(description = "Select car using filters: price, year of issue, car mileage, drive unit, car condition, body style",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectCarUsingFiltersTest2(CarFilterTwoData car) {
        rubricatorSteps.moveToSection(car.getSectionFirst());
        rubricatorSteps.moveToSection(car.getSectionSecond());
        searchFilterSteps.setValuesOfLimit(car.getPriceTitle(), car.getMinPrice(), car.getMaxPrice());
        searchFilterSteps.setValuesOfLimit(car.getYearOfIssueTitle(), car.getMinYearOfIssue(), car.getMaxYearOfIssue());
        searchFilterSteps.setValuesOfDropDownLimit(car.getCarMileageTitle(), car.getMaxCarMileage());
        searchFilterSteps.clickButtonOrCheckbox(car.getDriveUnitTitle(), car.getDriveUnit());
        searchFilterSteps.clickButtonOrCheckbox(car.getEngineTypeTitle(), car.getEngineType());
        searchFilterSteps.clickButtonOrCheckbox(car.getCarConditionTitle(), car.getCarCondition());
        searchFilterSteps.clickButtonOrCheckbox(car.getBodyStyleTitle(), car.getBodyStyle());
        searchFilterSteps.clickResultButton();

        int actual = sortResultSteps.getPriceFirstFoundObject();
        int minPrice = Integer.parseInt(car.getMinPrice());
        int maxPrice = Integer.parseInt(car.getMaxPrice());

        Assert.assertTrue(actual <= maxPrice && actual >= minPrice);
        List<String> parameters = new ArrayList<>(car.getParameters());
        Assert.assertTrue(sortResultSteps.doDescriptionsContainText(parameters, car.getNumberOfArrayElements()));
    }
}
