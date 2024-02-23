package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.realEstateTest.ApartmentData;
import org.akavity.models.realEstateTest.LandData;
import org.akavity.models.realEstateTest.RoomData;
import org.akavity.models.realEstateTest.SummerHouseData;
import org.akavity.steps.RealEstateSteps;
import org.akavity.steps.RubricatorSteps;
import org.akavity.steps.SortResultSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RealEstateTest extends BaseTest {
    RubricatorSteps rubricatorSteps = new RubricatorSteps();
    RealEstateSteps realEstateSteps = new RealEstateSteps();
    SortResultSteps sortResultSteps = new SortResultSteps();

    @TestData(jsonFile = "apartmentData", model = "ApartmentData", folder = "realEstateTest")
    @Test(description = "Check the sorting when searching for an apartment",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectApartmentUsingDesktop(ApartmentData apartment) {
        rubricatorSteps.moveToSection(apartment.getSection());
        realEstateSteps.selectTypeRealEstate(apartment.getTypeRealEstate());
        realEstateSteps.selectBuyOrRent(apartment.getIntention());
        realEstateSteps.selectCheckboxListItem(apartment.getDeskTopRooms(), apartment.getNumberOfRooms());
        realEstateSteps.selectValuesOfLimit(apartment.getLimitOfPrice(), apartment.getMinPrice(), apartment.getMaxPrice());
        realEstateSteps.clickShowResultButton();

        int actualPrice = sortResultSteps.getPriceFirstFoundObject();
        int minPrice = Integer.parseInt(apartment.getMinPrice());
        int maxPrice = Integer.parseInt(apartment.getMaxPrice());
        Assert.assertTrue(actualPrice <= maxPrice && actualPrice >= minPrice);

        String actualTitle = sortResultSteps.getNameOfFirstFoundObject();
        Assert.assertTrue(actualTitle.contains(apartment.getPartOftTitle()));
    }

    @TestData(jsonFile = "summerHouseData", model = "SummerHouseData", folder = "realEstateTest")
    @Test(description = "Check the sorting when searching for a summer house",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectSummerHouseUsingDesktop(SummerHouseData dacha) {
        rubricatorSteps.moveToSection(dacha.getSection());
        realEstateSteps.selectDropDownItem(dacha.getDeskTopApartment(), dacha.getDropDownDacha());
        realEstateSteps.selectCheckboxListItem(dacha.getTypeTitle(), dacha.getType());
        realEstateSteps.selectValuesOfLimit(dacha.getLimitOfArea(), dacha.getMinArea(), dacha.getMaxArea());
        realEstateSteps.selectValuesOfLimit(dacha.getLimitOfPrice(), dacha.getMinPrice(), dacha.getMaxPrice());
        realEstateSteps.clickShowResultButton();

        int actualPrice = sortResultSteps.getPriceFirstFoundObject();
        int minPrice = Integer.parseInt(dacha.getMinPrice());
        int maxPrice = Integer.parseInt(dacha.getMaxPrice());
        Assert.assertTrue(actualPrice <= maxPrice && actualPrice >= minPrice);

        int actualArea = sortResultSteps.extractAreaFromFirstFoundObject();
        int minArea = Integer.parseInt(dacha.getMinArea());
        int maxArea = Integer.parseInt(dacha.getMaxArea());
        Assert.assertTrue(actualArea <= maxArea && actualArea >= minArea);
    }

    @TestData(jsonFile = "roomData", model = "RoomData", folder = "realEstateTest")
    @Test(description = "Check the sorting when searching for a room",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectRoomUsingDesktop(RoomData room) {
        rubricatorSteps.moveToSection(room.getSection());
        realEstateSteps.selectDropDownItem(room.getDeskTopApartment(), room.getDropDownRoom());
        realEstateSteps.selectCheckboxListItem(room.getCheckboxRooms(), room.getNumberOfRooms());
        realEstateSteps.selectValuesOfLimit(room.getLimitOfArea(), room.getMinArea(), room.getMaxArea());
        realEstateSteps.selectValuesOfLimit(room.getLimitOfPrice(), room.getMinPrice(), room.getMaxPrice());
        realEstateSteps.clickShowResultButton();

        int actual = sortResultSteps.getPriceFirstFoundObject();
        int minPrice = Integer.parseInt(room.getMinPrice());
        int maxPrice = Integer.parseInt(room.getMaxPrice());

        Assert.assertTrue(actual <= maxPrice && actual >= minPrice);
    }

    @TestData(jsonFile = "landData", model = "LandData", folder = "realEstateTest")
    @Test(description = "Check the sorting when searching for a land",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectLandUsingDesktop(LandData land) {
        rubricatorSteps.moveToSection(land.getSection());
        realEstateSteps.selectDropDownItem(land.getDeskTopApartment(), land.getDropDownApartment());
        realEstateSteps.selectCheckboxListItem(land.getDeskTopLandType(), land.getCheckboxLandType());
        realEstateSteps.dragHandlesOfDoubleSlider(land.getDeskTopSlider(), land.getLeftHandleOffset(), land.getRightHandleOffset());
        realEstateSteps.selectValuesOfLimit(land.getLimitOfPrice(), land.getMinPrice(), land.getMaxPrice());
        realEstateSteps.clickShowResultButton();

        int actual = sortResultSteps.getPriceFirstFoundObject();
        int minPrice = Integer.parseInt(land.getMinPrice());
        int maxPrice = Integer.parseInt(land.getMaxPrice());

        Assert.assertTrue(actual <= maxPrice && actual >= minPrice);
    }
}
