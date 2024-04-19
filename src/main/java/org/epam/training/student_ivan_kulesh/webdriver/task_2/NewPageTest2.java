package org.epam.training.student_ivan_kulesh.webdriver.task_2;

import org.epam.training.student_ivan_kulesh.webdriver.task_1.NewPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewPageTest2 {

    private WebDriver driver;
    private NewPage newPage;


    @Test
    public void testCreateNewPaste() {
        String code =
                "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force\n";

        String title = "how to gain dominance among developers";

        driver = new ChromeDriver();
        newPage = new NewPage(driver);

        newPage.openPage();
        newPage.insertCode(code);
        newPage.formatChoose("//li[text()='Bash']");
        newPage.expirationTimeChoose("//li[text()='10 Minutes']");
        newPage.insertTitle(title);
        newPage.createButtonClick();

        
        Assertions.assertEquals(title,newPage.getTitle());
        Assertions.assertEquals("Bash",newPage.getFormat());
        Assertions.assertEquals(code,newPage.getCodeLines());

        driver.quit();
    }
}