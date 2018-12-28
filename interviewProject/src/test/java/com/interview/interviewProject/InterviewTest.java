package com.interview.interviewProject;

import java.io.InputStream;
import java.net.URL;

import javax.swing.text.Element;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.internal.MouseAction.Button;

/**
 * Unit test for simple App.
 */
public class InterviewTest
{
    
    /**
     * Create the test case
     *
     * 
     */
    @Test
    public void pullLeaderData()
    {
        String url = getClass().getClassLoader().getResource("chromedriver.exe").getPath();
        url=url.replace("%20", " ");
        System.setProperty("webdriver.chrome.driver", url);
        WebDriver driver = new ChromeDriver();
        try {
               
                String startUrl ="https://mailchimp.com/";
               
                driver.navigate().to(startUrl);
                Thread.sleep(5000);
                driver.findElement(By.linkText("GOT IT")).click();
                driver.findElement(By.linkText("Our Story")).click();
                Thread.sleep(5000);
                driver.findElement(By.linkText("Learn more about our leadership team")).click();
                driver.close();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
