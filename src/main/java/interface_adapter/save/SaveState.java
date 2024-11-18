package interface_adapter.save;

public class SaveState {
    private String rootArticleTitle;

    public SaveState() {
        rootArticleTitle = "";
    }

    public String getRootArticleTitle() {
        return rootArticleTitle;
    }

    public void setRootArticleTitle(String rootArticleTitle) {
        this.rootArticleTitle = rootArticleTitle;
    }
}
