package org.epam.training.student_ivan_kulesh.webdriver.task_3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleCloudTest {
    private WebDriver driver;
    private GoogleCloudPage newPage;


    @Test
    public void googleCloudTest(){
        driver = new ChromeDriver();
        newPage = new GoogleCloudPage(driver);

        newPage.openPage();
        newPage.searchBtnClick();
        newPage.searchInput("Google Cloud Platform Pricing Calculator");
        newPage.searchAccept();
        newPage.calculatorRedirect();

        driver.quit();
    }
}
