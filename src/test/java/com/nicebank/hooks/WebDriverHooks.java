package com.nicebank.hooks;

import com.nicebank.support.MyWebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

import javax.inject.Inject;

@ScenarioScoped
public class WebDriverHooks {

    private MyWebDriver webDriver;

    @Inject
    public WebDriverHooks(MyWebDriver webDriver) {
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
