package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

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
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    attach(By.name("photo"),contactData.getPhoto());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFaxPhone());
    type(By.name("email"), contactData.getEmail1());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getHomePage());
    selectFromList(By.name("bday"), contactData.getBirthDay());
    selectFromList(By.name("bmonth"), contactData.getBirthMonth());
    type(By.name("byear"), contactData.getBirthYear());
    selectFromList(By.name("aday"), contactData.getAnniversaryDay());
    selectFromList(By.name("amonth"), contactData.getAnniversaryMonth());
    type(By.name("ayear"), contactData.getAnniversaryYear());
    if (creation) {
      selectFromList(By.name("new_group"), contactData.getContactGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    type(By.name("address2"), contactData.getAdditionalAddress());
    type(By.name("phone2"), contactData.getAdditionalPhone());
    type(By.name("notes"), contactData.getAdditionalNotes());
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void submitContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void initContactModification(int id) {
    //нажимаем на карандашик, пример ссылки <a href="edit.php?id=62"><img src="icons/pencil.png" title="Edit" alt="Edit"></a>
    click(By.xpath("//a[@href='edit.php?id=" + id + "']"));
    /*
    //сначала находим чек-бокс, относительно него поднимаемся на 2 уровня вверх, в строке ищем
    //8 ячейку и в этой ячейке ищем ссылку
    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a",id))).click();
     */
   /*
   //найти строку, внутри строки находится инпут с заданным вэлью, относительно её ищем ячейку и ссылку
   wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a",id))).click();
    */
    /*
    //найти строку, внутри строки находится инпут с заданным вэлью, относительно её ищем ячейку и ссылку
   wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a",id))).click();
     */
    /*
    //просто ищем ссылку с нужны идентификатором
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
     */
  }

  public ContactData getContactInfoFromEditForm(ContactData contact) {
    initContactModification(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withAddress(address).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withEmail1(email1).withEmail2(email2).withEmail3(email3);
  }
  public void submitContactModification() {
    click(By.name("update"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModification(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    submitContactDeletion();
    closeAlert();
    contactCache = null;
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    //найти все элементы, которые имеют тэг tr и name entry
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    //проходим по всем элементам, заполняем список контактов, которые есть на странице
    for (WebElement element : elements) {
      //получаем ID
      int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
      String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
      String allPhones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
      String allEmails = element.findElement(By.cssSelector("td:nth-child(5)")).getText();
      //String[] phones = allPhones.split("\n");
      contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withAddress(address)
      .withAllPhones(allPhones).withAllEmails(allEmails));
    }
    return new Contacts(contactCache);
  }


}
