package use_case.add;

public class AddInteractor implements AddInputBoundary {
    private final AddOutputBoundary presenter;

    public AddInteractor(AddOutputBoundary presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute(AddInputData inputData) {
        // Use Case Success
        String title = inputData.getTitle();
        String content = inputData.getContent();
        // TODO: Record this webpage. This needs the implementation of the Journey or WikiHistory entity.
        AddOutputData outputData = new AddOutputData(title, content, false);
        presenter.prepareSuccessView(outputData);

        // TODO: Use Case Fails. This needs the implementation of the Journey or WikiHistory entity
    }
}
