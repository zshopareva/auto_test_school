package io.zshopareva;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;

public interface AllCarsPage extends WebPage {

    @FindBy("//span[contains(@class, 'Button__text')][.='1 владелец']/parent::span/parent::button")
    HtmlElement oneOwner();

}
