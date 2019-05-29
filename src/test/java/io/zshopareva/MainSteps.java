package io.zshopareva;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;
import io.qameta.htmlelements.element.HtmlElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class MainSteps {

    private WebDriver webDriver;

    public  MainSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openAllCarsPage(String url) {
        webDriver.get(url);
    }

    public void shouldSeeUrl(String url) {
        assertThat("Перешли на другую страницу",
                webDriver.getCurrentUrl(),
                containsString(url));
    }

    public AllCarsPage onAllCarsPage() {
        return on(AllCarsPage.class);
    }

    public void scrollToElement(HtmlElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript(String.format("window.scrollBy(0, %d)", element.getSize().getHeight() + 76));
    }

    protected <T extends WebPage> T on(Class<T> pageClass) {
        WebPageFactory factory = new WebPageFactory();
        return factory.get(webDriver, pageClass);
    }

    public void openAllCarsPage(){
        openAllCarsPage("https://auto.ru/cars/all/");
    }
}
