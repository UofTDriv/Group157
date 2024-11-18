package interface_adapter.navBar;

public class NavBarState {
    private String search = "Start a new Journey";
    private String save = "Save: No Journey";
    private String open = "Open Existing Journey";
    private String journey = "No Journey Open";
    private String graph = "No Journey Open";

    public String getSearch() {
        return search;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getGraph() {
        return graph;
    }

    public String getOpen() {
        return open;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

    public String getJourney() {
        return journey;
    }

    public void SetJourney(String journey) {
        this.journey = journey;
    }

//    public String getTimeline() {
//        return timeline;
//    }
//
//    public void setTimeline(String timeline) {
//        this.timeline = timeline;
//    }
}
