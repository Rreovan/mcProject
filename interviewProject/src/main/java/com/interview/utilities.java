package com.interview;

import org.apache.poi.ss.usermodel.Cell;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class utilities {
    Logger logger = Logger.getLogger(utilities.class.getName());

    public void writeExcelData(List<WebElement> listToBeAdded){
        try {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Board Memebers");

                int rowCount = 0;
                for(WebElement leaderElements: listToBeAdded){
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
                String fileLocation = System.getProperty("user.home");
                logger.info("the file has been saved to:  "+fileLocation);
                //FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Main User\\Documents\\JavaBooks.xlsx");
                FileOutputStream outputStream = new FileOutputStream(fileLocation+"\\InterviewMailChimp.xlsx");
                    workbook.write(outputStream);
                    workbook.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "file was not able to be created");
            e.printStackTrace();
				}
               
    }
}