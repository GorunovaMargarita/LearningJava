package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText=wd.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }
  protected void attach (By locator, File file) {
    if (file != null) {
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }
  }

  public void selectFromList(By locator, String text) {
    if (text != null) {
      click(locator);
      //игнорируем отсутствие групп в списке, но для прочих списков проверяем, что значение есть
      if (!locator.equals(By.name("new_group"))) {
        Assert.assertEquals(isTextInListPresent(locator, text), true);
        new Select(wd.findElement(locator)).selectByVisibleText(text);
      } else if (isTextInListPresent(locator, text)) {
        new Select(wd.findElement(locator)).selectByVisibleText(text);
      }
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
  public boolean isTextInListPresent (By locator, String text) {
    try {
      click(locator);
      new Select(wd.findElement(locator)).selectByVisibleText(text);
        return true;
    } catch(NoSuchElementException ex){
      return false;
    }
  }

}
