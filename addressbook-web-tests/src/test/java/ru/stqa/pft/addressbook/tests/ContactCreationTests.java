package ru.stqa.pft.addressbook.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillNewContactForm(new ContactData("FirstName1", "MiddleName1", "LastName1", "NickName1", "Title1", "Company1", "Address1", "1111", "1111", "1111", "1111", "mail1@mail.ru", "mail2@gmail.com", "mail3@ya.ru", "HomePage1", "1", "January", "1953", "1", "January", "2020", "test12", "Address2", "Home2", "Notes1"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }









}
