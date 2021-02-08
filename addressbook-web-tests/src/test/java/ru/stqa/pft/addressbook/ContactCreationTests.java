package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.get("http://localhost/addressbook/");
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login("admin", "secret");
  }

  @Test
  public void testContactCreation() throws Exception {
    initContactCreation();
    fillNewContactForm(new ContactData("FirstName1", "MiddleName1", "LastName1", "NickName1", "Title1", "Company1", "Address1", "1111", "1111", "1111", "1111", "mail1@mail.ru", "mail2@gmail.com", "mail3@ya.ru", "HomePage1", "1", "January", "1953", "1", "January", "2020", "Goryun Group", "Address2", "Home2", "Notes1"));
    submitContactCreation();
    returnToHomePage();
  }

  private void login(String login, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(login);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  private void returnToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void fillNewContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactData.getMobilePhone());
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(contactData.getWorkPhone());
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(contactData.getFaxPhone());
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail1());
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys(contactData.getHomePage());
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthDay());
    wd.findElement(By.name("bday")).click();
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthMonth());
    wd.findElement(By.name("bmonth")).click();
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(contactData.getBirthYear());
    wd.findElement(By.name("aday")).click();
    new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAnniversaryDay());
    wd.findElement(By.name("aday")).click();
    wd.findElement(By.name("amonth")).click();
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAnniversaryMonth());
    wd.findElement(By.name("amonth")).click();
    wd.findElement(By.name("ayear")).click();
    wd.findElement(By.name("ayear")).clear();
    wd.findElement(By.name("ayear")).sendKeys(contactData.getAnniversaryYear());
    wd.findElement(By.name("new_group")).click();
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getContactGroup());
    wd.findElement(By.name("new_group")).click();
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys(contactData.getAdditionalAddress());
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys(contactData.getAdditionalHome());
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys(contactData.getAdditionalNotes());
  }

  private void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.findElement(By.linkText("Logout")).click();
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
