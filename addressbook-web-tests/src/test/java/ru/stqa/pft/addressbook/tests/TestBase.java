package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {
//Static - самостоятельные глобальные переменные и методы, для их запуска не нужно создавать экземпляр класса
  protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
//для того, чтобы браузер не открывался каждый раз используем @BeforeSuite, а не @BeforeMethod
  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

}
