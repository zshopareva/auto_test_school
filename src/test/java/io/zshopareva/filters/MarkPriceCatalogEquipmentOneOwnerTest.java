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
    }

    @Test
    public void test(){
        mainSteps.openAllCarsPage();
        mainSteps.onAllCarsPage().allParams().click();
        mainSteps.onAllCarsPage().select("Марка", "Chery");
        mainSteps.onAllCarsPage().select("Коробка", "Вариатор");
        mainSteps.onAllCarsPage().buttonFilter("Частник").click();
        mainSteps.onAllCarsPage().checkBoxFilter("Противотуманные фары").click();
        mainSteps.onAllCarsPage().priceFrom().sendKeys("670000");
        mainSteps.onAllCarsPage().findCars().click();

        mainSteps.shouldSeeUrl("https://auto.ru/sankt-peterburg/cars/chery/all/?sort=fresh_relevance_1-desc&" +
                "transmission=VARIATOR&seller_group=PRIVATE&catalog_equipment=ptf&price_from=670000");
    }
}
