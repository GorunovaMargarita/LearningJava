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
    ContactData contact = new ContactData().withFirstName("FirstName1").withLastName("LastName1").withNickName("NickName1").withTitle("Title1").withMiddleName("MiddleName1").withAddress("Address1").withCompany("Company1").withWorkPhone("1111").withFaxPhone("1111").withMobilePhone("1111").withHomePhone("1111").withEmail1("mail1@mail.ru").withEmail2("mail2@gmail.com").withEmail3("mail3@ya.ru").withHomePage("HomePage1").withBirthDay("7").withBirthMonth("November").withBirthYear("1989").withAnniversaryDay("17").withAnniversaryMonth("January").withAnniversaryYear("2020").withContactGroup("test1").withAdditionalAddress("Address2").withHomePage("Home2").withAdditionalNotes("Notes1");
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
