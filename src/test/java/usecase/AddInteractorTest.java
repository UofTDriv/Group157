package usecase;

import data_access.InMemoryJourneyDataAccessObject;
import entity.Node;
import entity.WebPage;
import org.junit.jupiter.api.BeforeAll;
import use_case.add.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AddInteractorTest {


    @Test
    void successTest() {
        ArrayList<String> children1 = new ArrayList<>();
        children1.add("testNode");
        ArrayList<String> children2 = new ArrayList<>();
        children2.add("parent1");
        ArrayList<String> children3 = new ArrayList<>();
        children3.add("child1");
        ArrayList<String> children4 = new ArrayList<>();
        children3.add("child2");

        Node parentNode2 = new Node(new WebPage("parent2",""), null, children2, true);
        Node parentNode1 = new Node(new WebPage("parent1",""), parentNode2, children1, false);
        Node testNode = new Node(new WebPage("testNode",""), parentNode1, children3, true);
        Node childrenNode1 = new Node(new WebPage("child1",""), testNode, children4, false);
        Node childrenNode2 = new Node(new WebPage("child2",""), childrenNode1, null, true);


        AddInputData inputData = new AddInputData("testNode");
        AddDataAccessInterface dao = new AddDataAccessInterface() {
            @Override
            public Node getNode(String title) {
                Node result = null;
                if (title.equals("testNode")) {
                    result = testNode;
                }
                else if (title.equals("parent1")) {
                    result = parentNode1;
                }
                else if (title.equals("child1")) {
                    result = childrenNode1;
                }
                else if (title.equals("parentNode2")) {
                    result = parentNode2;
                }
                else {
                    result = childrenNode2;
                }
                return result;
            }

            @Override
            public Boolean containsAddedNodeTitle(String title) {
                return title == "testNode" || title == "parent2" || title == "child2";
            }
        };

        AddOutputBoundary testPresenter = new AddOutputBoundary() {
            @Override
            public void prepareSuccessView(AddOutputData outputData) {
                ArrayList parentList = new ArrayList();
                parentList.add("parent2");
                ArrayList childrenList = new ArrayList();
                childrenList.add("child2");
                assertEquals(parentList, outputData.getParents());
                assertEquals(childrenList, outputData.getChildren());
                assertEquals("testNode", outputData.getTitle());
                assertFalse(outputData.getUseCaseFailed());
            }

            @Override
            public void prepareFailView(AddOutputData outputData) {
                fail("Use case failure is unexpected.");
            }
        };

        AddInputBoundary interactor = new AddInteractor(testPresenter, dao);
        interactor.execute(inputData);

    }
}
