package com.interview;


import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class click{
    Logger logger = Logger.getLogger(click.class.getName());

    public void clickElement(WebDriver driver,  String variable){

        try {
            driver.findElement(By.linkText(variable)).click();
        } catch (Exception e) {
            logger.info("Unable to find by Link text");
        }

    }
}


