package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ObjectOfSalePage;

@Log4j2
public class ObjectOfSaleSteps {
    ObjectOfSalePage objectOfSalePage = new ObjectOfSalePage();

    @Step
    public int getPrice() {
        int result = Integer.parseInt(objectOfSalePage.getPriceField().getText().replace(" ", ""));
        log.info("Object of sales price: " + result);
        return  result;
    }
}
