package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("FirstName1", "MiddleName1", "LastName1", "NickName1", "Title1", "Company1", "Address1", "1111", "1111", "1111", "1111", "mail1@mail.ru", "mail2@gmail.com", "mail3@ya.ru", "HomePage1", "7", "November", "1989", "1", "January", "2020", null, "Address2", "Home2", "Notes1"));
    }
    app.goTo().goToHomePage();
  }

  @Test
  public void testContactModification(){
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size()-1;
    ContactData contact = new ContactData(before.get(index).getId(),"FirstName50", "MiddleName50", "LastName50", "NickName1", "Title1", "Company1", "AddressChange", "1111", "1111", "1111", null, "mail1@mail.ru", "mail2@gmail.com", null, "HomePage1", "1", "January", "1953", "1", "January", "2020", null,"Address2", "Home2", "Notes1");
    app.getContactHelper().modifyContact(before.get(index).getId(), contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    //сравниваем размеры списков до и после, размер не должен был измениться
    Assert.assertEquals(after.size(),before.size());
    //assertThat(after.size(), equalTo(before.size()));
    //удаляем из before элемент, который меняли
    before.remove(index);
    //добавляем в список before изменённый элемент
    before.add(contact);
    //Необходимо сравненение по именам и ID,т.к. иначе списки по с одинаковыми name схлопнутся.
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    //assertThat(after, equalTo(before));
  }


}
