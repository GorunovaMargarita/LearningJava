package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

public class UserHelper extends HelperBase{
  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void changeUserPasswd(UserData user) {
    app.goTo().manage();
    app.goTo().manageUsers();
    type(By.name("search"), user.getEmail());
    click(By.cssSelector("input[type='submit']"));
    click(By.xpath("//a[@href='/mantisbt-2.25.0/manage_overview_page.php']"));
  }
}
