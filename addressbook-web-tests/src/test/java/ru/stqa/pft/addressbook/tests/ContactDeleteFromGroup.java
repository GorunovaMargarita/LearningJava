package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactDeleteFromGroup extends TestBase{
  @BeforeMethod
  public void ensurePreconditionsContacts() {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstName("FirstName1").withLastName("LastName1").withNickName("NickName1").withTitle("Title1").withMiddleName("MiddleName1").withAddress("Address1").withCompany("Company1").withWorkPhone("1111").withFaxPhone("1111").withMobilePhone("1111").withHomePhone("1111").withEmail1("mail1@mail.ru").withEmail2("mail2@gmail.com").withEmail3("mail3@ya.ru").withHomePage("HomePage1").withBirthDay((byte) 7).withBirthMonth("November").withBirthYear("1989").withAnniversaryDay((byte) 17).withAnniversaryMonth("January").withAnniversaryYear("2020").withAdditionalAddress("Address2").withHomePage("Home2").withAdditionalNotes("Notes1"));
    }
  }
  @BeforeMethod
  public void ensurePreconditionsGroups() {
    if (app.db().groups().size()==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testDeleteContactFromGroup (){
    app.goTo().homePage();
    Contacts beforeContacts = app.db().contacts();
    ContactData contactForDeletionFromGroup =  beforeContacts.iterator().next();
    GroupData groupForContactDeletion = contactForDeletionFromGroup.getGroups().iterator().next();
    Groups contactGroupBefore = contactForDeletionFromGroup.getGroups();
    app.contact().deleteContactFromGroup(contactForDeletionFromGroup,groupForContactDeletion);
    Groups contactGroupAfter = contactForDeletionFromGroup.getGroups();
    assertThat(contactGroupAfter,equalTo(contactGroupBefore.without(groupForContactDeletion)));
  }
}
