package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size()==0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }
  @Test
  public void testGroupModification() {
    Set<GroupData> before = app.group().all();
    //берём группу из множества
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test100").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(),before.size());
    //убираем элемент, который меняли
    before.remove(modifiedGroup);
    //добавляем элемент в изменённом виде
    before.add(group);
    Assert.assertEquals(before,after);
  }


}
