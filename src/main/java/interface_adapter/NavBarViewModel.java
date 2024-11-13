package interface_adapter;

public class NavBarViewModel extends ViewModel<NavBarState> {

    private String search;
    private String save;
    private String openOrCurrent;
    private String graph;
    private String timeline;

    public NavBarViewModel() {
        super("Top Navigation Bar");
        NavBarState defaultState = new NavBarState();
        setState(defaultState);
        this.search = defaultState.getSearch();
        this.save = defaultState.getSave();
        this.openOrCurrent = defaultState.getOpenOrCurrent();
        this.graph = defaultState.getGraph();
        this.timeline = defaultState.getTimeline();
    }

    public String getSearch() {
        return search;
    }

    public String getSave() {
        return save;
    }

    public String getOpenOrCurrent() {
        return openOrCurrent;
    }

    public String getGraph() {
        return graph;
    }

    public String getTimeline() {
        return timeline;
    }
}
