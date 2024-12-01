package use_case.add;

import java.util.List;

/**
 * Output Data for the Add Use Case.
 */
public class AddOutputData {
  
    private final String title;
    private final List<String> parents;
    private final List<String> children;
    private final boolean useCaseFailed;

    public AddOutputData(String title, List<String> parents, List<String> children, boolean useCaseFailed) {
        this.title = title;
        this.parents = parents;
        this.children = children;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getParents() {
        return parents;
    }

    public List<String> getChildren() {
        return children;
    }

    public boolean getUseCaseFailed() {
        return useCaseFailed;
    }
}