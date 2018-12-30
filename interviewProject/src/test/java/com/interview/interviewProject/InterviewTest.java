package com.interview.interviewProject;

import java.util.List;
import java.util.logging.Logger;
import com.interview.click;
import com.interview.utilities;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class InterviewTest
{
    click clickAction = new click();
    utilities utils = new utilities();
    Logger logger = Logger.getLogger(InterviewTest.class.getName());
    String url = getClass().getClassLoader().getResource("chromedriver.exe").getPath();
    WebDriver driver;
       
    
    /**
     * Create the test case
     *
     * 
     */
    @Test
    public void pullLeaderData()
    {
        url=url.replace("%20", " ");
        System.setProperty("webdriver.chrome.driver", url);
        WebDriver driver = new ChromeDriver();
       
        String startUrl ="https://mailchimp.com/";
        driver.navigate().to(startUrl);
        clickAction.clickElement(driver ,"GOT IT");
        clickAction.clickElement(driver,"Our Story");
        clickAction.clickElement(driver,"Learn more about our leadership team");
        List<WebElement> leaderList= driver.findElements(By.className("bioList__content"));
        utils.writeExcelData(leaderList); 
        driver.close();
    }

}
