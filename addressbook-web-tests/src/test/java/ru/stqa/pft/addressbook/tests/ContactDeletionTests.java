package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactData("FirstName1", "MiddleName1", "LastName1", "NickName1", "Title1", "Company1", "Address1", "1111", "1111", "1111", "1111", "mail1@mail.ru", "mail2@gmail.com", "mail3@ya.ru", "HomePage1", "7", "November", "1989", "1", "January", "2020", "test1", "Address2", "Home2", "Notes1"));
    }
  }
  @Test
  public void testContactDeletion() {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    app.contact().delete(index);
    app.closeAlert();
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    //сравниваем размеры списков до и после, должен уменьшиться на 1
    Assert.assertEquals(after.size(),before.size()-1);
    //assertThat(after.size(), equalTo(before.size()-1));
    //удаляем из before элемент, выбранный для удаления
    before.remove(index);
    //сравниваем списки
    Assert.assertEquals(before,after);
    //assertThat(after, equalTo(before));
  }

}
