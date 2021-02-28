package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("FirstName1", "MiddleName1", "LastName1", "NickName1", "Title1", "Company1", "Address1", "1111", "1111", "1111", "1111", "mail1@mail.ru", "mail2@gmail.com", "mail3@ya.ru", "HomePage1", "7", "November", "1989", "17", "January", "2020", "test11", "Address2", "Home2", "Notes1");
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    //сравниваем размеры списков до и после, должен увеличиться на 1
    Assert.assertEquals(after.size(),before.size()+1);
    //assertThat(after.size(), equalTo(before.size()+1));
    //получаем ID созданного контакта, как максимальный ID в after
    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    //добавляем созданный контакт в изначальный список
    before.add(contact);
    //преобразуем списки в множества и сравниваем
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    //assertThat(after, equalTo(before));
  }

}
