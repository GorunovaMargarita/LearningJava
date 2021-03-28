package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

import java.io.IOException;

public class changePasswordTests extends TestBase{
  @Test
  public void testChangePassword() throws IOException {
    app.goTo().login(app.getProperty("web.adminLogin"),app.getProperty("web.adminPassword"));
    app.goTo().homePage();
    String email = "emai@email.ru";
    app.user().changeUserPasswd(email);
  }


}
