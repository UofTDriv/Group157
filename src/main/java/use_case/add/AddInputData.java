package use_case.add;

import entity.Node;

/**
 * Input Data for the Add Node use case.
 */
public class AddInputData {
    private final Node current;
    private final Node parents;

    public GraphInputData(Node current, Node parent) {
        this.current = current;
        this.parents = parent;
    }
}
