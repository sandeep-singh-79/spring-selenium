package com.demo.ssandeep.spring.springselenium.googletest;

import com.demo.ssandeep.spring.springselenium.SpringBaseTestNGTest;
import com.demo.ssandeep.spring.springselenium.kelvin.annotation.LazyAutowired;
import com.demo.ssandeep.spring.springselenium.kelvin.service.ScreenshotService;
import com.demo.ssandeep.spring.springselenium.page.google.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google2Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("selenium");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 25);
        this.screenshotService.takeScreenShot();
        this.googlePage.close();
    }

}
