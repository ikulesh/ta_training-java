package org.epam.training.student_ivan_kulesh.webdriver.task_1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class NewPage {

    private WebDriver driver;

    public NewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://pastebin.com/");
    }

    public void insertCode(String code) {
        WebElement codeTextArea = driver.findElement(By.id("postform-text"));
        codeTextArea.sendKeys(code);
    }

    public void expirationTimeChoose(String expirationXpath) {
        WebElement expirationDropdown = driver.findElement(By.id("select2-postform-expiration-container"));
        expirationDropdown.click();


        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/span[2]")));

        WebElement expirationDropdownCategory = driver
                .findElement(By.xpath("//span[contains(@class, 'select2-results')]"))
                .findElement(By.xpath(expirationXpath));
        expirationDropdownCategory.click();
    }

    public void formatChoose(String formatXpath) {
        WebElement expirationDropdown = driver.findElement(By.id("select2-postform-format-container"));
        expirationDropdown.click();


        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/span[2]")));

        WebElement expirationDropdownCategory = driver
                .findElement(By.xpath("//span[contains(@class, 'select2-results')]"))
                .findElement(By.xpath(formatXpath));
        expirationDropdownCategory.click();

    }

    public void insertTitle(String title) {
        WebElement titleField = driver.findElement(By.id("postform-name"));
        titleField.sendKeys(title);
    }

    public void createButtonClick() {
        WebElement createButton = driver.findElement(By.xpath("//*[@class=\"btn -big\"]"));
        createButton.click();
    }

    public String getTitle() {
        String xpath = "//div[contains(@class, 'info-top')]";
        waitingOfPresence(xpath);
        WebElement titleField = driver.findElement(By.xpath(xpath));
        return titleField.getText();
    }

    public String getFormat() {
        WebElement titleField = driver.findElement(By.xpath("//div[@class='left']/a[@href=\"/archive/bash\"]"));
        return titleField.getText();
    }

    public String getCodeLines() {
        List<WebElement> codeLines = driver.findElements(By.xpath("//div[@class='de1']"));
        String textCode = null;
        for (WebElement line : codeLines) {
            if (textCode == null) {
                textCode = line.getText();
            } else {
                textCode = textCode + "\n" + line.getText();
            }
        }
        assert textCode != null;
        return textCode.trim();
    }

    public void waitingOfPresence(String xpath){
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
}
