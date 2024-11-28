package use_case.add;

import entity.Graph;

public class AddOutputData {
    private final String successMessage;

    public AddOutputData(String useCaseStatus) {
        this.successMessage = useCaseStatus;
    }

    public String getSuccessMessage() {
        return this.successMessage;
    }
}
