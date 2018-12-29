package com.interview.interviewProject;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.text.Element;
import java.util.Arrays;
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
import org.openqa.selenium.interactions.internal.MouseAction.Button;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

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
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Java Books");
                String startUrl ="https://mailchimp.com/";
               
                driver.navigate().to(startUrl);
                driver.findElement(By.linkText("GOT IT")).click();
                driver.findElement(By.linkText("Our Story")).click();
                driver.findElement(By.linkText("Learn more about our leadership team")).click();
                List<WebElement> leaderList= driver.findElements(By.className("bioList__content"));
                int rowCount = 0;
                for(WebElement leaderElements: leaderList){
                    String name =leaderElements.findElement(By.className("h5")).getText();
                    List<WebElement> positionDescription =leaderElements.findElements(By.className("copy"));
                    String[] writeData= {name,positionDescription.get(0).getText(),positionDescription.get(1).getText()} ;
                    Row row = sheet.createRow(++rowCount);
                    int columnCount=0;
                    for( String columnValue:writeData) {
                        Cell cell = row.createCell(columnCount++);
                            cell.setCellValue((String) columnValue);
                       
                        }
                }
                FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Main User\\Documents\\JavaBooks.xlsx"); 
                workbook.write(outputStream);
                workbook.close();
                
                
                driver.close();
        
        } catch (FileNotFoundException e) {
            Assert.fail(e .toString());
            e.printStackTrace();
        } catch (IOException e) {
            Assert.fail(e .toString());
			e.printStackTrace();
		}
    }

}
