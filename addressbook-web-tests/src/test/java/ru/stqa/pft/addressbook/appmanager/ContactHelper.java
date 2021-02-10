package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

  public void fillNewContactForm(ContactData contactData) {
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
    chooseFromList(By.name("bday"), contactData.getBirthDay());
    chooseFromList(By.name("bmonth"),contactData.getBirthMonth());
    type(By.name("byear"),contactData.getBirthYear());
    chooseFromList(By.name("aday"),contactData.getAnniversaryDay());
    chooseFromList(By.name("amonth"),contactData.getAnniversaryMonth());
    type(By.name("ayear"),contactData.getAnniversaryYear());
    chooseFromList(By.name("new_group"),contactData.getContactGroup());
    type(By.name("address2"),contactData.getAdditionalAddress());
    type(By.name("phone2"),contactData.getAdditionalPhone());
    type(By.name("notes"),contactData.getAdditionalNotes());
  }


}