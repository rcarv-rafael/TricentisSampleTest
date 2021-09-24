package com.framework.helper;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class commonsHelper {
    public void chooseByIndex(WebElement element,
                              Integer elementIndex) {
        ExpectedConditions.visibilityOf(element);
        Select selectObject = new Select(element);
        selectObject.selectByIndex(elementIndex);
    }
}
