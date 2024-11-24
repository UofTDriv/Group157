package interface_adapter.navBar;

public class NavBarState {

    public final String SWITCH_ERROR = "No Journey Open";

    private String search = "Start a new Journey";
    private String save = "Save: " + SWITCH_ERROR;
    private String open = "Open Existing Journey";
    private String journey = SWITCH_ERROR;
    private String graph = SWITCH_ERROR;
    private String switchError = SWITCH_ERROR;

    public String getSwitchError() {
        return switchError;
    }

    public void setSwitchError(String switchError) {
        this.switchError = switchError;
    }

    public String getSearch() {
        return search;
    }

    public String getSave() {
        return save;
    }

    public String getGraph() {
        return graph;
    }

    public String getOpen() {
        return open;
    }

    public String getJourney() {
        return journey;
    }

    public void setJourney(String rootPageTitle) {
        this.journey = rootPageTitle;
        this.save = "Save: " + rootPageTitle;
        this.graph = "Graph: " + rootPageTitle;
    }

//    public String getTimeline() {
//        return timeline;
//    }
//
//    public void setTimeline(String timeline) {
//        this.timeline = timeline;
//    }
}
