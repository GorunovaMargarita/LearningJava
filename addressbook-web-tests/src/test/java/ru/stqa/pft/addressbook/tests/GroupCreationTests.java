package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(),before.size()+1);
    //из потока объектов типа GroupData получаем поток целых чисел, получаем максимальное число, преобразуем результат в целое число
    group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before,after);
    //ищем индентификатор новой группы как максимальный индентификатор
    //присваиваем найденный макс ID новой группе
    //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    //преобразуем списки в множества и сравниваем
    //Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }

}
