package interface_adapter;

public class NavBarViewModel extends ViewModel<NavBarState> {

    public NavBarViewModel() {
        super("Top Navigation Bar");
        NavBarState defaultState = new NavBarState();
        setState(defaultState);
    }
}
