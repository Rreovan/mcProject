package com.interview.interviewProject;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.interview.click;
import com.interview.utilities;
import javax.swing.text.Element;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.chrome.ChromeDriver;
import junit.framework.AssertionFailedError;

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
