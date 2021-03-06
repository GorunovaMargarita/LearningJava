package ru.stqa.pft;

import org.testng.SkipException;

import java.io.IOException;
import java.util.Objects;
import java.util.Set;


public class TestBase {


  public boolean isIssueOpen(int issueId) throws IOException {
    //Issue issueWithId = IssueHelper.getIssueById(issueId);
    Issue issueWithId = IssueHelper.getIssueByIdAPI(issueId);
    if (issueWithId!=null) {
      String issueStatus = issueWithId.getStateName();
      if(issueStatus.equals("Closed")){
        return false;
      } else {
        return true;
      }
    }
    return false;
  }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}
