package use_case.save;

import entity.Node;

import java.util.List;

public class SaveOutputData {

    private final String message;
    private final String saveTitle;
    private final List<Node> wikiHistoryToBeSaved;

    public SaveOutputData(String message, String saveTitle, List<Node> wikiHistoryToBeSaved) {
        this.message = message;
        this.saveTitle = saveTitle;
        this.wikiHistoryToBeSaved = wikiHistoryToBeSaved;
    }

    public String getMessage() { return this.message; }

    public String getSaveTitle() { return this.saveTitle; }

    public List<Node> getWikiHistoryToBeSaved() { return this.wikiHistoryToBeSaved; }
}
