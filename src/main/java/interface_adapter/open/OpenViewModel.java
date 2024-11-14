package interface_adapter.open;

import interface_adapter.ViewModel;

public class OpenViewModel extends ViewModel<OpenState> {

    public static final String INFO_LABEL = "Click on a saved Journey to open it";

    public OpenViewModel() {
        super("Open");
        setState(new OpenState());
    }
}
