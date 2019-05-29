package io.zshopareva;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;
import io.qameta.htmlelements.element.HtmlElement;

public interface AllCarsPage extends WebPage {
    @Description("Фильтр с выподающим списком {{ value }}")
    @FindBy("//button[contains(@class, 'Select__button')]//span[contains(.,'{{ value }}')]")
    HtmlElement selectButton(@Param("value") String value);

    @Description("Кнопка {{ value }}")
    @FindBy("//span[@class='Button__text'][contains(., '{{ value }}')]")
    HtmlElement buttonFilter(@Param("value") String value);

    @Description("Чекбокс {{ value }}")
    @FindBy("//label[contains(@class, 'Checkbox')]//span[contains(., '{{ value }}')]")
    HtmlElement checkBoxFilter(@Param("value") String value);

    @FindBy(".//div[contains(@class, 'MenuItem')][contains(., '{{ value }}')]")
    HtmlElement item(@Param("value") String value);

    @FindBy("//span[contains(.,'Все параметры')]")
    HtmlElement allParams();

    @FindBy("//span[@class='ButtonWithLoader__content']")
    HtmlElement findCars();

    @FindBy("//input[@name='price_from']")
    HtmlElement priceFromInput();


    default void select(String filterName, String value){
        selectButton(filterName).click();
        item(value).click();
    }

}
