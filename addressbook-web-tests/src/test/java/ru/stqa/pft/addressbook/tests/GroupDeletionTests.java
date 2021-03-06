package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size()==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Groups before = app.db().groups();
    app.goTo().groupPage();
    //берём группу из множества
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size() - 1));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(deletedGroup)));
  }
  @Test(enabled = false)
  public void testAllGroupDeletion() throws Exception {
    app.goTo().groupPage();
    while (app.db().groups().size() != 0) {
      Groups before = app.db().groups();
      //берём группу из множества
      GroupData deletedGroup = before.iterator().next();
      app.group().delete(deletedGroup);
    }
    Groups after = app.db().groups();
    assertThat(after.size(), equalTo(0));
  }


}
