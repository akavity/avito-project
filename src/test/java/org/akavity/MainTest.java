package org.akavity;

import org.akavity.steps.NavigationSteps;
import org.akavity.steps.RealEstateSteps;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {
    NavigationSteps navigationSteps = new NavigationSteps();
    RealEstateSteps realEstateSteps = new RealEstateSteps();

    @Test
    public void test() {
        navigationSteps.moveToSection("Недвиж");
        realEstateSteps.selectTypeRealEstate("Квартира");
        realEstateSteps.selectBuyOrRent("Купить");
        realEstateSteps.selectBuildTime("Новостройка");
    }
}
