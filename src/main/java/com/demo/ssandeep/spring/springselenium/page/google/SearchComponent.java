package com.demo.ssandeep.spring.springselenium.page.google;

import com.demo.ssandeep.spring.springselenium.kelvin.annotation.PageFragment;
import com.demo.ssandeep.spring.springselenium.kelvin.annotation.TakeScreenshot;
import com.demo.ssandeep.spring.springselenium.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchComponent extends Base {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtns;

    @TakeScreenshot
    public void search(final String keyword){
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchBtns
                .stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.searchBox.isDisplayed());
    }
}
