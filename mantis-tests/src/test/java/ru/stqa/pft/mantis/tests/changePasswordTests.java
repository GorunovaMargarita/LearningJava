package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class changePasswordTests extends TestBase{
  @Test
  public void testChangePassword() throws IOException, MessagingException {
    Users users = app.db().users();
    UserData userForChangePass = users.iterator().next();
    app.goTo().login(app.getProperty("web.adminLogin"),app.getProperty("web.adminPassword"));
    app.goTo().homePage();
    //UserData user = new UserData().withEmail("testmail1@mail.ru").withPassword("password");
    String newPasswd = "newpass";
    app.james().createUser(userForChangePass.getUsername(),userForChangePass.getPassword());
    app.user().changeUserPasswd(userForChangePass,newPasswd);
    assertTrue(app.newSession().login(userForChangePass.getUsername(),newPasswd));
  }


}
