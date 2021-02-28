package ru.stqa.pft.addressbook.model;
//библиотека даёт набор классов для построения коллекций с расширенным набором методов
import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {
  private Set<ContactData> delegate;

  public Contacts(Contacts contacts) {
    this.delegate=new HashSet<ContactData>(contacts.delegate);
  }

  public Contacts() {
    this.delegate=new HashSet<ContactData>();
  }

  @Override
  protected Set<ContactData> delegate() {
    return delegate;
  }

  public Contacts withAdded(ContactData contact) {
    //создаём копию переданного объекта
    Contacts contacts = new Contacts(this);
    //добавляем объкт, которые передан в качестве параметра
    contacts.add(contact);
    //возвращаем копию с добавленным объектом
    return contacts;
  }

  public Contacts without(ContactData contact) {
    //создаём копию переданного объекта
    Contacts contacts = new Contacts(this);
    //удаляем объкт, которые передан в качестве параметра
    contacts.remove(contact);
    //возвращаем копию без удалённого объекта
    return contacts;
  }
}
