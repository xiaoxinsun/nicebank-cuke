package com.nicebank.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class WebDriverHooks {

    private EventFiringWebDriver webDriver;

    @Autowired
    public WebDriverHooks(EventFiringWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @After
    public void finish(Scenario scenario) {
        try {
            byte[] screenshot = webDriver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformDontSupportScreenshots) {
            System.err.println(somePlatformDontSupportScreenshots.getMessage());
        } finally {
            webDriver.close();
        }
    }

}
