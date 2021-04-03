package ru.stqa.pft;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTest extends TestBase{
  @Test
  public void testCreateIssue() throws IOException {
    skipIfNotFixed(705);
    Set<Issue> oldIssues =IssueHelper.getIssues();
    System.out.println(oldIssues);
    Issue newIssue = new Issue().withSubject("test issue").withDescription("new test issue");
    int issueId = IssueHelper.createIssue(newIssue);
    oldIssues.add(newIssue.withId(issueId));
    Set<Issue> newIssues = IssueHelper.getIssues();
    assertEquals(newIssues,oldIssues);
  }

}

