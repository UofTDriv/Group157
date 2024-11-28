package use_case.add;

public class AddOutputData {
  
    private final String title;
    private final boolean useCaseFailed;

    public AddOutputData(String title, boolean useCaseFailed) {
        this.title = title;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTitle() {
        return title;
    }

    public boolean getUseCaseFailed() {
        return useCaseFailed;
    }
}