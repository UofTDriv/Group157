package interface_adapter.save;

import interface_adapter.ViewModel;

public class SaveViewModel extends ViewModel<SaveState> {

    public static final String TOPTEXT_LABEL = "Save current journey to file";
    public static final String INPUT_TITLE_LABEL = "Title:";
    public static final String ROOT = "Root article:";
    public static final String SAVE_BUTTON_LABEL = "Save to file";

    public SaveViewModel() {
        super("Save");
        setState(new SaveState());
    }
}
