package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  @Test (enabled = false)
  public void testContactDeletion() {
    app.goTo().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("FirstName1", "MiddleName1", "LastName1", "NickName1", "Title1", "Company1", "Address1", "1111", "1111", "1111", "1111", "mail1@mail.ru", "mail2@gmail.com", "mail3@ya.ru", "HomePage1", "7", "November", "1989", "1", "January", "2020", "test1", "Address2", "Home2", "Notes1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().submitContactDeletion();
    app.closeAlert();
    app.goTo().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    //сравниваем размеры списков до и после, должен уменьшиться на 1
    Assert.assertEquals(after.size(),before.size()-1);
    //удаляем из before элемент, выбранный для удаления
    before.remove(before.size()-1);
    //сравниваем списки
    Assert.assertEquals(before,after);
  }
}
