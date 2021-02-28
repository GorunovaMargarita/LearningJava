package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("FirstName1").withLastName("LastName1").withNickName("NickName1").withTitle("Title1").withMiddleName("MiddleName1").withAddress("Address1").withCompany("Company1").withWorkPhone("1111").withFaxPhone("1111").withMobilePhone("1111").withHomePhone("1111").withEmail1("mail1@mail.ru").withEmail2("mail2@gmail.com").withEmail3("mail3@ya.ru").withHomePage("HomePage1").withBirthDay("7").withBirthMonth("November").withBirthYear("1989").withAnniversaryDay("17").withAnniversaryMonth("January").withAnniversaryYear("2020").withContactGroup("test1").withAdditionalAddress("Address2").withHomePage("Home2").withAdditionalNotes("Notes1"));
    }
  }

  @Test
  public void testContactDeletion() {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    //iterator позволяет последовательно перебирать элелементы множества
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.closeAlert();
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    //сравниваем размеры списков до и после, должен уменьшиться на 1
    assertThat(after.size(), equalTo(before.size() - 1));
    //удаляем из before элемент, выбранный для удаления
    before.remove(deletedContact);
    //сравниваем множества
    assertThat(after, equalTo(before));
  }

}
