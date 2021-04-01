package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.model.Issue;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Arrays;

public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);

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

  @BeforeMethod
  public void logTestStart(Method m, Object[] p){
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }
  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m, Object[] p){
    logger.info("Stop test " + m.getName()+ " with parameters " + Arrays.asList(p));
  }

  public boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    Issue issue = app.soap().getIssue(issueId);
    if(issue.getStatus().equals("resolved")){
      return false;
    } else {
      return true;
    }
  }
  public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}
