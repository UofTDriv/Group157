package interface_adapter.navBar;

import interface_adapter.ViewModel;

public class NavBarViewModel extends ViewModel<NavBarState> {

    public NavBarViewModel() {
        super("NavBar");
        NavBarState defaultState = new NavBarState();
        setState(defaultState);
    }
}
