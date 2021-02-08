package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickName;
  private final String title;
  private final String company;
  private final String address;
  private final String homePhone;
  private final String mobilePhone;
  private final String workPhone;
  private final String faxPhone;
  private final String email1;
  private final String email2;
  private final String email3;
  private final String homePage;
  private final String birthDay;
  private final String birthMonth;
  private final String birthYear;
  private final String anniversaryDay;
  private final String anniversaryMonth;
  private final String anniversaryYear;
  private final String contactGroup;
  private final String additionalAddress;
  private final String additionalHome;
  private final String additionalNotes;

  public ContactData(String firstName, String middleName, String lastName, String nickName, String title, String company, String address, String homePhone, String mobilePhone, String workPhone, String faxPhone, String email1, String email2, String email3, String homePage, String birthDay, String birthMonth, String birthYear, String anniversaryDay, String anniversaryMonth, String anniversaryYear, String contactGroup, String additionalAddress, String additionalHome, String additionalNotes) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.workPhone = workPhone;
    this.faxPhone = faxPhone;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.homePage = homePage;
    this.birthDay = birthDay;
    this.birthMonth = birthMonth;
    this.birthYear = birthYear;
    this.anniversaryDay = anniversaryDay;
    this.anniversaryMonth = anniversaryMonth;
    this.anniversaryYear = anniversaryYear;
    this.contactGroup = contactGroup;
    this.additionalAddress = additionalAddress;
    this.additionalHome = additionalHome;
    this.additionalNotes = additionalNotes;
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

  public String getAdditionalHome() {
    return additionalHome;
  }

  public String getAdditionalNotes() {
    return additionalNotes;
  }
}
