package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase{
  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void changeUserPasswd(String email,String) {
    app.goTo().manage();
    app.goTo().manageUsers();
    type(By.name("search"),email);
  }
}
