package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size()==0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }
  @Test(enabled = false)
  public void testGroupModification() {
   Groups before = app.group().all();
    //берём группу из множества
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test100").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    Groups after = app.group().all();
    assertThat(after.size(),equalTo(before.size()));
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }


}
