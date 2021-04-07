package ru.stqa.pft;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class IssueHelper {



  public static Issue getOpenedIssueById (int issueId) throws IOException {
    Set<Issue> issues = getIssues();
    Set<Issue> issueWithId = issues.stream().filter(Issue -> Objects.equals(issueId, Issue.getId())).collect(Collectors.toSet());
    //issues.stream().filter(Issue -> Objects.equals(issueId, Issue.getId())).findFirst().get();
    if (issueWithId.size() == 0) {
      return null;
    } else {
      Issue issue = issueWithId.iterator().next();
      return issue;
    }
  }
  public static Issue getIssueByIdAPI(int issueId) throws IOException {
    String json =getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues/" + issueId + ".json")).returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    Set<Issue> issueWithId = new Gson().fromJson(issues,new TypeToken<Set<Issue>>(){}.getType());
    return issueWithId.iterator().next();
  }
  public static Set<Issue> getIssues() throws IOException {
    String json =getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues.json")).returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues,new TypeToken<Set<Issue>>(){}.getType());
  }

  private static Executor getExecutor() {
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490","");
  }

  public static int createIssue(Issue newIssue) throws IOException {
    String json = getExecutor().execute(Request.Post("https://bugify.stqa.ru/api/issues.json")
            .bodyForm(new BasicNameValuePair("subject",newIssue.getSubject()),
                    new BasicNameValuePair("description",newIssue.getDescription())))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }
}

