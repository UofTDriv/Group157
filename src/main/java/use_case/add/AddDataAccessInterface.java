package use_case.add;

import entity.Node;

import java.util.ArrayList;

public interface AddDataAccessInterface {

    public Node getNode(String title);

    public Boolean containsAddedNodeTitle(String title);

}
