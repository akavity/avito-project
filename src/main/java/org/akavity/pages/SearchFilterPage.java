package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchFilterPage {

    public SelenideElement getFilterButtonAndCheckout(String title, String text) {
        return $(By.xpath("//div[starts-with(@class,'fieldset')]//span[contains(text(),'" + title + "')]" +
                "/../../following-sibling::div//span[contains (text(),'" + text + "')]/../.."));
    }
    //div[starts-with(@class,'fieldset')]//span[contains(@class,'text-bold') and contains(text(),'')]

    public SelenideElement getFilterField(String title) {
        return $(By.xpath("//div[starts-with(@class,'fieldset')]//span[contains(text(),'" + title + "')]" +
                "/../../following-sibling::div"));
    }

    public SelenideElement getCheckboxItem(String name) {
        return $(By.xpath("//div[@role='button']/p[contains(text(),'" + name + "')]/../.."));
    }

    public SelenideElement getValueOfMinLimit(String title) {
        return $(By.xpath("//span[contains(text(),'" + title + "')]" +
                "/../../following-sibling::div//input[contains(@data-marker,'from')]"));
    }

    public SelenideElement getValueOfMaxLimit(String title) {
        return $(By.xpath("//span[contains(text(),'" + title + "')]" +
                "/../../following-sibling::div//input[contains(@data-marker,'to')]"));
    }

    public SelenideElement getValueOfMinDropDownLimit(String title) {
        return $(By.xpath("//div[starts-with(@class,'fieldset')]//span[contains(text(),'" + title + "')]" +
                "/../../following-sibling::div//input[contains(@data-marker,'from')]"));
    }

//div[starts-with(@class,'fieldset')]//span[contains(text(),'На')]/../../following-sibling::div


    //div[starts-with(@class,'fieldset')]//span[contains(text(),'На')]/../../following-sibling::div

    //h5[contains(text(),'')]/..//following-sibling::div//p[contains(text(),'')]/../..  поиск марки авто

    //div[@role='button']/p[contains(text(),'')]/ancestor::div[contains(@class,'title')]  checkbox прозводитель, модель
    //div[@role='button']/p[contains(text(),'')]/../..

    //div[starts-with(@class,'fieldset')]//span[contains(@class,'text-bold') and contains(text(),'')] title  28
    //div[starts-with(@class,'fieldset')]//span[contains(text(),'" + title + "')]   use it )

    //span[contains(text(),'клиринс')]/../../following-sibling::div//span[contains (text(),'от')]/../..
}
