// Based on the example code at http://www.seleniumhq.org/docs/03_webdriver.jsp
package edu.drexel.se320;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class SeleniumTest {

    @Test
    public void testSomething() {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        try {
            // Visit Google
            driver.get("http://www.google.com");

            // Find the text input element by its name
            WebElement element = driver.findElement(By.name("q"));

            // Enter something to search for
            element.sendKeys("drexel university");

            // Now submit the form. WebDriver will find the form for us from the element
            element.submit();

            // Check the title of the page
            
            // Google's search is rendered dynamically with JavaScript.
            // Wait for the page to load, timeout after 10 seconds
            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("drexel");
                }
            });

            // Should see: "drexel university - Google Search"
            assertEquals("foobardrexel university - Google Search", driver.getTitle());
        } finally {
            //Close the browser
            driver.quit();
        }
    }
}
