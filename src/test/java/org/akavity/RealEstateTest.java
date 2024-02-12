package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.ApartmentData;
import org.akavity.models.RoomData;
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
    public void selectApartment(ApartmentData apartment) {
        mainSteps.moveToSection(apartment.getSection());
        realEstateSteps.selectTypeRealEstate(apartment.getTypeRealEstate());
        realEstateSteps.selectBuyOrRent(apartment.getIntention());
        realEstateSteps.selectCheckboxListItem(apartment.getDeskTopRooms(), apartment.getNumberOfRooms());
        realEstateSteps.selectValuesOfLimit(apartment.getLimitOfPrice(), apartment.getMinPrice(), apartment.getMaxPrice());
        realEstateSteps.clickShowResultButton();
        int actual = sortResultSteps.getPriceFirstFoundObject();
        int minPrice = Integer.parseInt(apartment.getMinPrice());
        int maxPrice = Integer.parseInt(apartment.getMaxPrice());

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

    @TestData(jsonFile = "roomData", model = "RoomData")
    @Test(description = "Check the sorting when searching for a room",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectRoom(RoomData room) {
        mainSteps.moveToSection(room.getSection());
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

    @Test(description = "Check the sorting when searching for a summer house")
    public void selectArea() {
        mainSteps.moveToSection("Недвиж");
        realEstateSteps.selectDropDownItem("Квартира", "Земельный");
        realEstateSteps.selectCheckboxListItem("Категория земель", "Поселений");
        realEstateSteps.selectValuesOfSlider("Площадь","40","500");
        realEstateSteps.selectValuesOfLimit("Цена", "400000", "1000000");
        realEstateSteps.clickShowResultButton();
    }
}
