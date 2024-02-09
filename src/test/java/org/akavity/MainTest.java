package org.akavity;

import org.akavity.steps.NavigationSteps;
import org.akavity.steps.ObjectOfSaleSteps;
import org.akavity.steps.RealEstateSteps;
import org.akavity.steps.SortingResultSteps;
import org.akavity.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {
    NavigationSteps navigationSteps = new NavigationSteps();
    RealEstateSteps realEstateSteps = new RealEstateSteps();
    SortingResultSteps sortingResultSteps = new SortingResultSteps();
    ObjectOfSaleSteps objectOfSaleSteps = new ObjectOfSaleSteps();

    Utils utils = new Utils();

    @Test
    public void test() {
        navigationSteps.moveToSection("Недвиж");
        realEstateSteps.selectTypeRealEstate("Квартира");
        realEstateSteps.selectBuyOrRent("Купить");
        realEstateSteps.selectBuildTime("Новостройка");
    }

    @Test
    public void selectApartment() {
        navigationSteps.moveToSection("Недвиж");
        realEstateSteps.selectTypeRealEstate("Квартира");
        realEstateSteps.selectBuyOrRent("Купить");
        realEstateSteps.selectCheckboxListItem("Комнаты", "2 комнаты");
        realEstateSteps.selectValuesOfLimit("Цена", "2000000", "5000000");
        realEstateSteps.clickShowResultButton();
        sortingResultSteps.clickFirstSortingResult();
        utils.sleep(3000);
        int actual = objectOfSaleSteps.getPrice();

        Assert.assertTrue(actual <= 5000000 && actual >= 2000000);

        utils.sleep(5000);
    }
}
