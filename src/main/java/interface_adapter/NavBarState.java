package interface_adapter;

public class NavBarState {
    private String search = "Start a new Journey";
    private String save = "Save: No Journey";
    private String openOrCurrent = "Open Existing Journey";
    private String graph = "No Journey Open";
    private String timeline = "No Journey Open";

    // TODO change to better variables

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public String getOpenOrCurrent() {
        return openOrCurrent;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setOpenOrCurrent(String open) {
        this.openOrCurrent = open;
    }
}
