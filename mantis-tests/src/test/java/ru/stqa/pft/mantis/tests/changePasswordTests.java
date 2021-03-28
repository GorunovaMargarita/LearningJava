package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import java.io.IOException;

public class changePasswordTests extends TestBase{
  @Test
  public void testChangePassword() throws IOException {
    Users users = app.db().users();
    UserData userForChangePass = users.iterator().next();
    app.goTo().login(app.getProperty("web.adminLogin"),app.getProperty("web.adminPassword"));
    app.goTo().homePage();
    //UserData user = new UserData().withEmail("testmail1@mail.ru").withPassword("password");
    app.user().changeUserPasswd(userForChangePass);
    System.out.println(users);
  }


}
