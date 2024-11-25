package use_case.add;

/**
 * Input Data for the Add Node use case.
 */
public class AddInputData {
    private final String title;
    private final String content;

    public AddInputData(String title, String content) {
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
