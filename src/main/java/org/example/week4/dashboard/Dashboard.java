package org.example.week4.dashboard;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.List;

public class Dashboard {

    private static final String USER = "Hambak-note";

    public static void main(String[] args) throws IOException {

        GitHub github = new GitHubBuilder().withOAuthToken("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").build();

        GHRepository repository = github.getRepository("Hambak-note/java-live-study");
        List<GHIssue> issues = repository.getIssues(GHIssueState.ALL);

        int totalIssue = issues.size();
        int totalCommentUser = 0;

        for (GHIssue issue : issues) {
            List<GHIssueComment> comments = issue.getComments();
            for (GHIssueComment comment : comments) {
                GHUser user = comment.getUser();
                if(user.getLogin().equals(USER)) totalCommentUser++;
            }
        }

        System.out.printf("참여율 : %.2f%n", (totalIssue / (float) totalCommentUser));
    }


}
