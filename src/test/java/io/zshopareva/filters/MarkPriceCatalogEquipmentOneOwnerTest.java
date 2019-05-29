package io.zshopareva.filters;

import io.zshopareva.MainSteps;
import io.zshopareva.WebDriverRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MarkPriceCatalogEquipmentOneOwnerTest {

    MainSteps mainSteps;

    @Rule
    public WebDriverRule driverRule = new WebDriverRule();

    @Before
    public void setUp() {
        mainSteps = new MainSteps(driverRule.driver());
        mainSteps.openAllCarsPage();
    }

    @Test
    public void checkMarkInUrl(){
        mainSteps.onAllCarsPage().allParams().click();
        mainSteps.onAllCarsPage().select("Марка", "Chery");
        mainSteps.onAllCarsPage().findCars().click();
        mainSteps.shouldSeeUrl("https://auto.ru/sankt-peterburg/cars/chery/all/?sort=fresh_relevance_1-desc");
    }


    @Test
    public void checkPriceFromInUrl(){
        mainSteps.onAllCarsPage().priceFromInput().sendKeys("670000");
        mainSteps.onAllCarsPage().findCars().click();
        mainSteps.shouldSeeUrl("https://auto.ru/sankt-peterburg/cars/all/?sort=fresh_relevance_1-desc&price_from=670000");
    }

    @Test
    public void checkTransmissionInUrl(){
        mainSteps.onAllCarsPage().select("Коробка", "Вариатор");
        mainSteps.onAllCarsPage().findCars().click();
        mainSteps.shouldSeeUrl("https://auto.ru/sankt-peterburg/cars/all/?sort=fresh_relevance_1-desc&" +
                "transmission=VARIATOR");
    }

    @Test
    public void checkCatalogEquipmentPtf(){
        mainSteps.onAllCarsPage().allParams().click();
        mainSteps.onAllCarsPage().checkBoxFilter("Противотуманные фары").click();
        mainSteps.onAllCarsPage().findCars().click();
        mainSteps.shouldSeeUrl("https://auto.ru/sankt-peterburg/cars/all/?sort=fresh_relevance_1-desc&catalog_equipment=ptf");
    }

    @Test
    public void checkSellerGroupPrivate(){
        mainSteps.onAllCarsPage().allParams().click();
        mainSteps.onAllCarsPage().buttonFilter("Частник").click();
        mainSteps.onAllCarsPage().findCars().click();
        mainSteps.shouldSeeUrl("https://auto.ru/sankt-peterburg/cars/all/?sort=fresh_relevance_1-desc&seller_group=PRIVATE");
    }
}
