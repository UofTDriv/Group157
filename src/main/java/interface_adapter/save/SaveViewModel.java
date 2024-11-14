package interface_adapter.save;

import interface_adapter.ViewModel;

public class SaveViewModel extends ViewModel<SaveState> {

    public static final String INFO_LABEL = "Save current journey to file";
    public static final String INPUT_TITLE_LABEL = "Title:";
    public static final String ROOT = "Root article:";
    public static final String SAVE_BUTTON_LABEL = "Root article:";

    public SaveViewModel() {
        super("Save");
        setState(new SaveState());
    }
}
