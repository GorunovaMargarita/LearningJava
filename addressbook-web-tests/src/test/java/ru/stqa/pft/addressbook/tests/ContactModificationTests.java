package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactData().withFirstName("FirstName1").withLastName("LastName1").withNickName("NickName1").withTitle("Title1").withMiddleName("MiddleName1").withAddress("Address1").withCompany("Company1").withWorkPhone("1111").withFaxPhone("1111").withMobilePhone("1111").withHomePhone("1111").withEmail1("mail1@mail.ru").withEmail2("mail2@gmail.com").withEmail3("mail3@ya.ru").withHomePage("HomePage1").withBirthDay("7").withBirthMonth("November").withBirthYear("1989").withAnniversaryDay("17").withAnniversaryMonth("January").withAnniversaryYear("2020").withContactGroup("test1").withAdditionalAddress("Address2").withHomePage("Home2").withAdditionalNotes("Notes1"));
    }
  }

  @Test
  public void testContactModification(){
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstName("FirstName145").withLastName("LastName150").withNickName("NickName1").withTitle("Title1").withMiddleName("MiddleName1").withAddress("Address1").withCompany("Company1").withWorkPhone("1111").withFaxPhone("1111").withMobilePhone("1111").withHomePhone("1111").withEmail1("mail1@mail.ru").withEmail2("mail2@gmail.com").withEmail3("mail3@ya.ru").withHomePage("HomePage1").withBirthDay("7").withBirthMonth("November").withBirthYear("1989").withAnniversaryDay("17").withAnniversaryMonth("January").withAnniversaryYear("2020").withContactGroup("test1").withAdditionalAddress("Address2").withHomePage("Home2").withAdditionalNotes("Notes1");
    app.contact().modify(before.get(index).getId(), contact);
    List<ContactData> after = app.contact().list();
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
