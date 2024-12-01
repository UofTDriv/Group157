package use_case.graph;

import entity.WebPage;

public class GraphOutputData {
    final private String title;
    final private String content;

    public GraphOutputData(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
