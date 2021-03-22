package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

public class registrationTests extends TestBase {

  @Test
  public void testRegistrarion() {
    app.registration().start("user1","user1@localhost.localadmin");
  }
}
