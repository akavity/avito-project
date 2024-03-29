package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.realEstateTest.*;
import org.akavity.steps.RealEstateSteps;
import org.akavity.steps.RubricatorSteps;
import org.akavity.steps.SearchFilterSteps;
import org.akavity.steps.SortResultSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RealEstateTest extends BaseTest {
    RubricatorSteps rubricatorSteps = new RubricatorSteps();
    SearchFilterSteps searchFilterSteps = new SearchFilterSteps();
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

        double actualArea = sortResultSteps.extractAreaFromFirstFoundObject();
        double minArea = Double.parseDouble(dacha.getMinArea());
        double maxArea = Double.parseDouble(dacha.getMaxArea());
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

        double actualArea = sortResultSteps.extractAreaFromFirstFoundObject();
        double minArea = Double.parseDouble(room.getMinArea());
        double maxArea = Double.parseDouble(room.getMaxArea());
        Assert.assertTrue(actualArea <= maxArea && actualArea >= minArea);
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

    @TestData(jsonFile = "apartmentFilterData", model = "ApartmentFilterData", folder = "realEstateTest")
    @Test(description = "Select apartment using filters: number of rooms, min and max price, min and max area, repair," +
            " bathroom type, house type", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectApartmentUsingFilters(ApartmentFilterData apartment) {
        rubricatorSteps.moveToSection(apartment.getSection());
        realEstateSteps.clickShowResultButton();
        searchFilterSteps.clickCheckbox(apartment.getNumberOfRoomsTitle(), apartment.getNumberOfRooms());
        searchFilterSteps.setValuesOfLimit(apartment.getLimitOfPrice(), apartment.getMinPrice(), apartment.getMaxPrice());
        searchFilterSteps.setValuesOfLimit(apartment.getLimitOfArea(), apartment.getMinArea(), apartment.getMaxArea());
        searchFilterSteps.clickButton(apartment.getRepairTitle(), apartment.getRepair());
        searchFilterSteps.clickButton(apartment.getBathroomTypeTitle(), apartment.getBathroomType());
        searchFilterSteps.clickCheckbox(apartment.getHouseTypeTitle(), apartment.getHouseType());
        searchFilterSteps.clickResultButton();

        int actual = sortResultSteps.getPriceFirstFoundObject();
        int minPrice = Integer.parseInt(apartment.getMinPrice());
        int maxPrice = Integer.parseInt(apartment.getMaxPrice());
        Assert.assertTrue(actual <= maxPrice && actual >= minPrice);

        double actualArea = sortResultSteps.extractAreaFromFirstFoundObject();
        double minArea = Double.parseDouble(apartment.getMinArea());
        double maxArea = Double.parseDouble(apartment.getMaxArea());
        Assert.assertTrue(actualArea <= maxArea && actualArea >= minArea);

        Assert.assertTrue(sortResultSteps.getNameOfFirstFoundObject().contains(apartment.getPartOfName()));
    }

    @TestData(jsonFile = "summerHouseFilterData", model = "SummerHouseFilterData", folder = "realEstateTest")
    @Test(description = "Select summer house using filters: min and max price, min and max house area, min and max land " +
            "area, number of floors, number of rooms,", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectSummerHouseUsingFilters(SummerHouseFilterData dacha) {
        rubricatorSteps.moveToSection(dacha.getSection());
        realEstateSteps.selectDropDownItem(dacha.getDeskTopApartment(), dacha.getDropDownDacha());
        realEstateSteps.clickShowResultButton();
        searchFilterSteps.clickCheckbox(dacha.getTypeTitle(), dacha.getType());
        searchFilterSteps.setValuesOfLimit(dacha.getLimitOfPrice(), dacha.getMinPrice(), dacha.getMaxPrice());
        searchFilterSteps.setValuesOfLimit(dacha.getLimitOfHouseArea(), dacha.getMinHouseArea(), dacha.getMaxHouseArea());
        searchFilterSteps.setValuesOfLimit(dacha.getLimitOfLandArea(), dacha.getMinLandArea(), dacha.getMaxLandArea());
        searchFilterSteps.clickCheckbox(dacha.getFloorsTitle(), dacha.getNumberOfFloors());
        searchFilterSteps.clickCheckbox(dacha.getRoomsTitle(), dacha.getNumberOfRooms());
        searchFilterSteps.clickResultButton();

        int actual = sortResultSteps.getPriceFirstFoundObject();
        int minPrice = Integer.parseInt(dacha.getMinPrice());
        int maxPrice = Integer.parseInt(dacha.getMaxPrice());
        Assert.assertTrue(actual <= maxPrice && actual >= minPrice);

        double actualArea = sortResultSteps.extractAreaFromFirstFoundObject();
        double minArea = Double.parseDouble(dacha.getMinHouseArea());
        double maxArea = Double.parseDouble(dacha.getMaxHouseArea());
        Assert.assertTrue(actualArea <= maxArea && actualArea >= minArea);

        Assert.assertTrue(sortResultSteps.doTitlesContainSpecificName(dacha.getPartOfName(), 5));
    }
}
