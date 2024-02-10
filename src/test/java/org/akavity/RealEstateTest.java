package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.ApartmentData;
import org.akavity.steps.MainSteps;
import org.akavity.steps.RealEstateSteps;
import org.akavity.steps.SortingResultSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RealEstateTest extends BaseTest {
    MainSteps mainSteps = new MainSteps();
    RealEstateSteps realEstateSteps = new RealEstateSteps();
    SortingResultSteps sortingResultSteps = new SortingResultSteps();

    @TestData(jsonFile = "apartmentData", model = "ApartmentData")
    @Test(description = "Check registration form data",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectApartment(ApartmentData apartmentData) {
        mainSteps.moveToSection(apartmentData.getSection());
        realEstateSteps.selectTypeRealEstate(apartmentData.getTypeRealEstate());
        realEstateSteps.selectBuyOrRent(apartmentData.getBuyOrRent());
        realEstateSteps.selectCheckboxListItem(apartmentData.getDeskTopRooms(), apartmentData.getNumberOfRooms());
        realEstateSteps.selectValuesOfLimit(apartmentData.getLimitOfPrice(), apartmentData.getMinPrice(), apartmentData.getMaxPrice());
        realEstateSteps.clickShowResultButton();
        int actual = sortingResultSteps.getPriceFirstFoundObject();
        int minPrice = Integer.parseInt(apartmentData.getMinPrice());
        int maxPrice = Integer.parseInt(apartmentData.getMaxPrice());

        Assert.assertTrue(actual <= maxPrice && actual >= minPrice);
    }
}
