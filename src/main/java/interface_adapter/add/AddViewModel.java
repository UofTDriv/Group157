package interface_adapter.add;

import interface_adapter.ViewModel;

public class AddViewModel extends ViewModel<AddState> {

    public AddViewModel() {
        super("Graph");
        setState(new AddState());
    }
}
