package org.epam.training.student_ivan_kulesh.webdriver.task_1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewPageTest {

    private WebDriver driver;
    private NewPage newPage;


    @Test
    public void testCreateNewPaste() {
        driver = new ChromeDriver();
        newPage = new NewPage(driver);

        newPage.openPage();
        newPage.insertCode("Hello from WebDriver");
        newPage.expirationTimeChoose("//li[text()='10 Minutes']");
        newPage.insertTitle("helloweb");
        newPage.createButtonClick();
        driver.quit();
    }
}
