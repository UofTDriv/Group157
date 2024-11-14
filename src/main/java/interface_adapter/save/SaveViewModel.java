package interface_adapter.save;

import interface_adapter.ViewModel;

public class SaveViewModel extends ViewModel<SaveState> {
    public SaveViewModel() {
        super("Save");
        setState(new SaveState());
    }
}
