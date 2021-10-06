package org.movoto.selenium.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class ChromeDriverTest {

    private String testUrl;
    private WebDriver driver;

    @Before
    public void prepare() {
        //setup chromedriver
        System.setProperty(
                "webdriver.chrome.driver",
                "webdriver/chromedriver");

//        testUrl = "https://google.com";

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();

        //maximize window
        driver.manage().window().maximize();

        // Alternatively the same thing can be done like this
        // driver.navigate().to(testUrl);
        // driver.get(testUrl);

    }

    @Test
    public void testTitle() throws Exception {

        driver.get("https://www.google.com");
        assertThat(driver.getTitle(), containsString("Google"));

        Thread.sleep(10000);
    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}
