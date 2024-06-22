package uitest.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import service.driver.Driver;
import uitest.page.CasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestCase2 extends CasePage {

    @BeforeMethod
    public void setUp() throws InterruptedException {
        cookieReject.click();
        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOf(searchFieldClickElement));
        action.moveToElement(searchFieldClickElement).click().perform();
        searchField.sendKeys("iphone");
        searchButton.click();

        List<WebElement> productLinks = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(
                        By.xpath("//li[@class='productListContent-zAP0Y5msy8OHn5z7T_K_']//a[@href]")));
        List<String> endpoints = new ArrayList<>();
        for (WebElement link : productLinks) {
            endpoints.add(link.getAttribute("href"));
        }
        if (endpoints.isEmpty()) {
            throw new NoSuchElementException("No product links found");
        }
        Random rand = new Random();
        String randomEndpoint = endpoints.get(rand.nextInt(endpoints.size()));
        System.out.println(randomEndpoint);

        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        js.executeScript("window.open()");

        for (String handle : Driver.getDriver().getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);
                break;
            }
        }
        Driver.getDriver().get(randomEndpoint);
    }

    @Test(description = "Check thanks text", priority = 2)
    public void runCase2() {
        wait.until(ExpectedConditions.visibilityOf(comments));
        comments.click();

        if (productPicture != null) {
            wait.until(ExpectedConditions.visibilityOf(productPicture));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", sortingComment);
        sortingCommentOption.click();
        theLatestComment.click();
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", productComments);
        likingComment.click();
        wait.until(ExpectedConditions.visibilityOf(thankYourLiking));
        String thanksText = thankYourLiking.getText();
        Assert.assertEquals(thanksText, "Teşekkür Ederiz.");
    }

    @AfterMethod(description = "Close all windows and main page after each test")
    public void tearDown() {
        Driver.closeAllWindowsAndCloseMain();
    }
}
