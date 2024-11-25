package use_case.add;

public class AddOutputData {
    private final String title;
    private final String content;
    private final boolean useCaseFailed;

    public AddOutputData(String title, String content, boolean useCaseFailed) {
        this.title = title;
        this.content = content;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean getUseCaseFailed() {
        return useCaseFailed;
    }
}
