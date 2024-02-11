package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.ApartmentData;
import org.akavity.models.SummerHouseData;
import org.akavity.steps.MainSteps;
import org.akavity.steps.RealEstateSteps;
import org.akavity.steps.SortResultSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RealEstateTest extends BaseTest {
    MainSteps mainSteps = new MainSteps();
    RealEstateSteps realEstateSteps = new RealEstateSteps();
    SortResultSteps sortResultSteps = new SortResultSteps();

    @TestData(jsonFile = "apartmentData", model = "ApartmentData")
    @Test(description = "Check the sorting when searching for an apartment",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectApartment(ApartmentData apartmentData) {
        mainSteps.moveToSection(apartmentData.getSection());
        realEstateSteps.selectTypeRealEstate(apartmentData.getTypeRealEstate());
        realEstateSteps.selectBuyOrRent(apartmentData.getIntention());
        realEstateSteps.selectCheckboxListItem(apartmentData.getDeskTopRooms(), apartmentData.getNumberOfRooms());
        realEstateSteps.selectValuesOfLimit(apartmentData.getLimitOfPrice(), apartmentData.getMinPrice(), apartmentData.getMaxPrice());
        realEstateSteps.clickShowResultButton();
        int actual = sortResultSteps.getPriceFirstFoundObject();
        int minPrice = Integer.parseInt(apartmentData.getMinPrice());
        int maxPrice = Integer.parseInt(apartmentData.getMaxPrice());

        Assert.assertTrue(actual <= maxPrice && actual >= minPrice);
    }

    @TestData(jsonFile = "summerHouseData", model = "SummerHouseData")
    @Test(description = "Check the sorting when searching for a summer house",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectSummerHouse(SummerHouseData dacha) {
        mainSteps.moveToSection(dacha.getSection());
        realEstateSteps.selectDropDownItem(dacha.getDeskTopApartment(), dacha.getDropDownDacha());
        realEstateSteps.selectValuesOfLimit(dacha.getLimitOfArea(), dacha.getMinArea(), dacha.getMaxArea());
        realEstateSteps.selectValuesOfLimit(dacha.getLimitOfPrice(), dacha.getMinPrice(), dacha.getMaxPrice());
        realEstateSteps.clickShowResultButton();

        int actual = sortResultSteps.getPriceFirstFoundObject();
        int minPrice = Integer.parseInt(dacha.getMinPrice());
        int maxPrice = Integer.parseInt(dacha.getMaxPrice());

        Assert.assertTrue(actual <= maxPrice && actual >= minPrice);
    }
}
