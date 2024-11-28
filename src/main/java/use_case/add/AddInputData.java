package use_case.add;

/**
 * Input Data for the Add Node use case.
 */
public class AddInputData {
    private final String title;

    public AddInputData(String title) {
        this.title = title;
    }
  
    public String getTitle() {
        return title;
    }
}