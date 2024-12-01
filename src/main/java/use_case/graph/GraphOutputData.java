package use_case.graph;

/**
 * Output Data for the Graph Use Case.
 */
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
