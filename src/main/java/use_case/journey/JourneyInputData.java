package use_case.journey;

/**
 * Input data for the journey use case.
 */
public class JourneyInputData {

    private final String subject;

    public JourneyInputData(String searchString) {
        this.subject = searchString;
    }

    public String getSubject() {
        return this.subject;
    }
}
