package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;
@Entity
@Table(name="addressbook")

public class ContactData {
  @Id
  @Column(name="id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name="firstName")
  private String firstName;
  private String middleName;
  @Expose
  @Column(name="lastName")
  private String lastName;
  @Transient
  private String nickName;
  @Transient
  private String title;
  @Transient
  private String company;
  @Expose
  @Column(name="address")
  @Type(type = "text")
  private  String address;
  @Expose
  @Column(name="home")
  @Type(type = "text")
  private  String homePhone;
  @Expose
  @Column(name="mobile")
  @Type(type = "text")
  private  String mobilePhone;
  @Expose
  @Column(name="work")
  @Type(type = "text")
  private  String workPhone;
  @Transient
  private  String faxPhone;
  @Expose
  @Transient
  private  String email1;
  @Expose
  @Transient
  private  String email2;
  @Expose
  @Transient
  private  String email3;
  @Transient
  private  String homePage;
  @Transient
  private  String birthDay;
  @Transient
  private  String birthMonth;
  @Transient
  private  String birthYear;
  @Transient
  private  String anniversaryDay;
  @Transient
  private  String anniversaryMonth;
  @Transient
  private  String anniversaryYear;
  @Transient
  private  String contactGroup;
  @Transient
  private  String additionalAddress;
  @Transient
  private  String additionalHome;
  @Transient
  private  String additionalNotes;
  @Transient
  private String AllPhones;
  @Transient
  private String AllEmails;
  @Column(name="photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }


  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFaxPhone() {
    return faxPhone;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomePage() {
    return homePage;
  }

  public String getBirthDay() {
    return birthDay;
  }

  public String getBirthMonth() {
    return birthMonth;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public String getAnniversaryDay() {
    return anniversaryDay;
  }

  public String getAnniversaryMonth() {
    return anniversaryMonth;
  }

  public String getAnniversaryYear() {
    return anniversaryYear;
  }

  public String getContactGroup() {
    return contactGroup;
  }

  public String getAdditionalAddress() {
    return additionalAddress;
  }

  public String getAdditionalPhone() {
    return additionalHome;
  }

  public String getAdditionalNotes() {
    return additionalNotes;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  public String getAllPhones() {
    return AllPhones;
  }


  public String getAllEmails() {
    return AllEmails;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withFaxPhone(String faxPhone) {
    this.faxPhone = faxPhone;
    return this;
  }

  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withHomePage(String homePage) {
    this.homePage = homePage;
    return this;
  }

  public ContactData withBirthDay(String birthDay) {
    this.birthDay = birthDay;
    return this;
  }

  public ContactData withBirthMonth(String birthMonth) {
    this.birthMonth = birthMonth;
    return this;
  }

  public ContactData withBirthYear(String birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  public ContactData withAnniversaryDay(String anniversaryDay) {
    this.anniversaryDay = anniversaryDay;
    return this;
  }

  public ContactData withAnniversaryMonth(String anniversaryMonth) {
    this.anniversaryMonth = anniversaryMonth;
    return this;
  }

  public ContactData withAnniversaryYear(String anniversaryYear) {
    this.anniversaryYear = anniversaryYear;
    return this;
  }

  public ContactData withContactGroup(String contactGroup) {
    this.contactGroup = contactGroup;
    return this;
  }

  public ContactData withAdditionalAddress(String additionalAddress) {
    this.additionalAddress = additionalAddress;
    return this;
  }

  public ContactData withAdditionalHome(String additionalHome) {
    this.additionalHome = additionalHome;
    return this;
  }

  public ContactData withAdditionalNotes(String additionalNotes) {
    this.additionalNotes = additionalNotes;
    return this;
  }
  public ContactData withAllPhones(String allPhones) {
    this.AllPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.AllEmails = allEmails;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, address);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }
}
