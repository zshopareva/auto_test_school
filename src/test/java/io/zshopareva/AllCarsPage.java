package io.zshopareva;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;
import io.qameta.htmlelements.element.HtmlElement;

public interface AllCarsPage extends WebPage {
    @Description("Фильтр с выподающим списком {{ value }}")
    @FindBy("//button[@class='Button Button_size_m Button_type_button Button_width_default Select__button']//span[contains(.,'{{ value }}')]")
    HtmlElement selectButton(@Param("value") String value);

    @Description("Кнопка {{ value }}")
    @FindBy("//span[@class='Button__text'][contains(., '{{ value }}')]")
    HtmlElement buttonFilter(@Param("value") String value);

    @Description("Чекбокс {{ value }}")
    @FindBy("//label[contains(@class, 'Checkbox')]//span[contains(., '{{ value }}')]")
    HtmlElement checkBoxFilter(@Param("value") String value);

    @FindBy("//div[contains(@class, 'Popup_js_inited')][contains(@class, 'Popup_visible')]")
    HtmlElement filterPopup();

    @FindBy(".//div[contains(@class, 'MenuItem MenuItem_size_m')][contains(., '{{ value }}')]")
    HtmlElement item(@Param("value") String value);

    @FindBy("//span[contains(.,'Все параметры')]")
    HtmlElement allParams();

    @FindBy("//span[@class='ButtonWithLoader__content']")
    HtmlElement findCars();

    @FindBy("//input[@name='price_from']")
    HtmlElement priceFrom();


    default void select(String filterName, String value){
        selectButton(filterName).click();
        filterPopup();
        item(value).click();
    }

}
