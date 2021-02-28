package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
  }

  public void submitContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void initContactModification(int id) {
    //нажимаем на карандашик, пример ссылки <a href="edit.php?id=62"><img src="icons/pencil.png" title="Edit" alt="Edit"></a>
    click(By.xpath("//a[@href='edit.php?id=" + id + "']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact,true);
    submitContactCreation();
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModification(contact.getId());
    fillContactForm(contact,false);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    submitContactDeletion();
  }


  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    //найти все элементы, которые имеют тэг tr и name entry
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    //проходим по всем элементам, заполняем список контактов, которые есть на странице
    for (WebElement element : elements){
      //получаем ID
      int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
      String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withAddress(address));
    }
    return contacts;
  }


}
