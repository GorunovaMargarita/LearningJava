package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
    this.wd = app.getDriver();
  }
  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"),username);
    click(By.cssSelector("input[type='submit']"));
    type(By.name("password"),password);
    click(By.cssSelector("input[type='submit']"));
  }
  public void manage() {
    if (isElementPresent(By.cssSelector("table#manage-overview-table"))){
      return;
    }
    click(By.xpath("//a[@href='/mantisbt-2.25.0/manage_overview_page.php']"));
    //wd.findElement(By.name(" Управление ")).click();
  }


  public void homePage() {
    click(By.xpath("//a[@href='/mantisbt-2.25.0/my_view_page.php']"));
  }
  public void manageUsers() {
    click(By.xpath("//a[@href='/mantisbt-2.25.0/manage_user_page.php']"));
  }
}
