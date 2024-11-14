package interface_adapter.journey;

import interface_adapter.ViewModel;

public class JourneyViewModel extends ViewModel<JourneyState> {

    public static final String ADDPAGES_CHECK_LABEL = "Add New Pages Automatically";
    public static final String ADDPAGE_BUTTON_LABEL = "Add Current Page to Graph";

    public JourneyViewModel() {
        super("Journey");
        setState(new JourneyState());
    }
}
