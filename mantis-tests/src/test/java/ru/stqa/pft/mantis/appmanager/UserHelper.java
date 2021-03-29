package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class UserHelper extends HelperBase{
  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void changeUserPasswd(UserData user,String password) throws IOException, MessagingException {
    app.goTo().manage();
    app.goTo().manageUsers();
    app.james().drainEmail(user.getUsername(), user.getPassword());
    type(By.id("search"), user.getEmail());
    click(By.cssSelector("input[type='submit']"));
    wd.findElement(By.linkText(user.getUsername())).click();
    wd.findElement(By.xpath("//input[@value='Сбросить пароль']")).click();
    List<MailMessage> mailMessages = app.james().waitForMail(user.getUsername(), user.getPassword(), 60000);
    String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
    app.registration().finish(confirmationLink,password);
  }

  public String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }
}
