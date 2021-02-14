package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }
  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }
  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"),contactData.getFirstName());
    type(By.name("middlename"),contactData.getMiddleName());
    type(By.name("lastname"),contactData.getLastName());
    type(By.name("nickname"),contactData.getNickName());
    type(By.name("title"),contactData.getTitle());
    type(By.name("company"),contactData.getCompany());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getHomePhone());
    type(By.name("mobile"),contactData.getMobilePhone());
    type(By.name("work"),contactData.getWorkPhone());
    type(By.name("fax"),contactData.getFaxPhone());
    type(By.name("email"),contactData.getEmail1());
    type(By.name("email2"),contactData.getEmail2());
    type(By.name("email3"),contactData.getEmail3());
    type(By.name("homepage"),contactData.getHomePage());
    selectFromList(By.name("bday"), contactData.getBirthDay());
    selectFromList(By.name("bmonth"),contactData.getBirthMonth());
    type(By.name("byear"),contactData.getBirthYear());
    selectFromList(By.name("aday"),contactData.getAnniversaryDay());
    selectFromList(By.name("amonth"),contactData.getAnniversaryMonth());
    type(By.name("ayear"),contactData.getAnniversaryYear());
    if (creation) {
      selectFromList(By.name("new_group"),contactData.getContactGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    type(By.name("address2"),contactData.getAdditionalAddress());
    type(By.name("phone2"),contactData.getAdditionalPhone());
    type(By.name("notes"),contactData.getAdditionalNotes());
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void submitContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm(contact,true);
    submitContactCreation();
    returnToHomePage();
  }
}
