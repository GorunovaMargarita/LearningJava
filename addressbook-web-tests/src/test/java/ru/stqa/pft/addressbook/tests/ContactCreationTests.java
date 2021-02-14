package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("FirstName1", "MiddleName1", "LastName1", "NickName1", "Title1", "Company1", "Address1", "1111", "1111", "1111", "1111", "mail1@mail.ru", "mail2@gmail.com", "mail3@ya.ru", "HomePage1", "7", "movember", "1989", "1", "January", "2020", "test1", "Address2", "Home2", "Notes1"),true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }









}
