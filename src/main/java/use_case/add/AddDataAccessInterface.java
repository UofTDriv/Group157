package use_case.add;

import entity.Node;

import java.util.ArrayList;

public interface AddDataAccessInterface {

    Node getNode(String title);

    Boolean containsAddedNodeTitle(String title);

}
