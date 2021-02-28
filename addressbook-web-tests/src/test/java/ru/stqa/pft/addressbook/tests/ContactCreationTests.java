package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("FirstName5").withLastName("LastName1").withNickName("NickName1").withTitle("Title1").withMiddleName("MiddleName1").withAddress("Address1").withCompany("Company1").withWorkPhone("1111").withFaxPhone("1111").withMobilePhone("1111").withHomePhone("1111").withEmail1("mail1@mail.ru").withEmail2("mail2@gmail.com").withEmail3("mail3@ya.ru").withHomePage("HomePage1").withBirthDay("7").withBirthMonth("November").withBirthYear("1989").withAnniversaryDay("17").withAnniversaryMonth("January").withAnniversaryYear("2020").withContactGroup("test1").withAdditionalAddress("Address2").withHomePage("Home2").withAdditionalNotes("Notes1");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    //сравниваем размеры списков до и после, должен увеличиться на 1
    assertThat(after.size(), equalTo(before.size() + 1));
    //получаем ID созданного контакта, как максимальный ID в after
    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    //добавляем созданный контакт
    before.add(contact);
    assertThat(after, equalTo(before.withAddedContact(contact)));
  }

}
