package org.epam.training.student_ivan_kulesh.webdriver.task_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPage {
    private WebDriver driver;

    public GoogleCloudPage(WebDriver driver) {
        this.driver = driver;
    }

    private String searchBtn = "//div[@class=\"YSM5S\"]";
    private String searchInputField = "//*[@id=\"i4\"]";
    private String searchAcceptBtn = "//i[contains(@role, 'button') and text() = 'send_spark']";
    private String calculatorPath = "//a[@track-metadata-eventdetail=\"cloud.google.com/products/calculator-legacy\"]";

    public void openPage() {
        driver.get("https://cloud.google.com/");
    }

    public void waitUntilIsExist(String xpath) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public void clickByXpath(String xpath) {
        waitUntilIsExist(xpath);
        WebElement searchAccept = driver.findElement(By.xpath(xpath));
        searchAccept.click();
    }

    public void searchInput(String request) {
        waitUntilIsExist(searchInputField);

        WebElement searchField = driver.findElement(By.xpath(searchInputField));
        searchField.sendKeys(request);
        //Assertions.assertEquals(request, searchField.getText());
    }

    public void searchBtnClick() {
        clickByXpath(searchBtn);
    }

    public void searchAccept() {
        clickByXpath(searchAcceptBtn);
    }

    public void calculatorRedirect() {
        clickByXpath(calculatorPath);
    }


}
