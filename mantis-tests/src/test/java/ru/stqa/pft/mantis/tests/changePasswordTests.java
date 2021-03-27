package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

public class changePasswordTests extends TestBase{
  @Test
  public void testChangePassword() throws IOException {
    app.goTo().login(app.getProperty("web.adminLogin"),app.getProperty("web.adminPassword"));
    app.goTo().homePage();
    changeUserPasswd();
  }
  private void changeUserPasswd() {
    app.goTo().manage();
    app.goTo().manageUsers();

  }

}
