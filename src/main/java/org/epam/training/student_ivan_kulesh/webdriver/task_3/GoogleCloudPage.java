package org.epam.training.student_ivan_kulesh.webdriver.task_3;

import org.openqa.selenium.WebDriver;

public class GoogleCloudPage {
    private WebDriver driver;

    public GoogleCloudPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://cloud.google.com/");
    }


}
