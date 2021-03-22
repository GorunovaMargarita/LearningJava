package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

import java.io.File;

public class TestBase {

//Static - самостоятельные глобальные переменные и методы, для их запуска не нужно создавать экземпляр класса
  /*protected static final ApplicationManager app
        = new ApplicationManager(BrowserType.FIREFOX);*/
protected static final ApplicationManager app
        =new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

//для того, чтобы браузер не открывался каждый раз используем @BeforeSuite, а не @BeforeMethod
  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"),"config_inc.php","config_inc.php.back");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.ftp().restore("config_inc.php.back","config_inc.php");
    app.stop();
  }
}