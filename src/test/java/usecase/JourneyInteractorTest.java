package usecase;

import data_access.InMemoryJourneyDataAccessObject;
import data_access.WikipediaAccessObject;
import entity.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.journey.*;
import use_case.search.SearchDataAccessInterface;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JourneyInteractorTest {

    public JourneyDataAccessInterface journeyDAO;
    public SearchDataAccessInterface searchDAO;
    public JourneyOutputBoundary presenter;

    @BeforeEach
    public void setUp() {
        this.journeyDAO = new InMemoryJourneyDataAccessObject();
        this.searchDAO = new WikipediaAccessObject();
    }

    @Test
    void notAWikiArticle() {
        this.presenter = new JourneyOutputBoundary() {
            @Override
            public void prepareSuccessView(JourneyOutputData outputData) {

            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertTrue(errorMessage.equals("Not a Wikipedia article link"));
            }
        };

        ArrayList<String> parentChildren = new ArrayList<>();
        parentChildren.add("United States");
        Node parent = Node.createNode("Canada", "blah", null, parentChildren, true);
        journeyDAO.setRootNode(parent);


        JourneyInputData inputData = new JourneyInputData("article");
        JourneyInteractor interactor = new JourneyInteractor(searchDAO, journeyDAO, presenter);

        interactor.execute(inputData);
    }

    @Test
    void noPageFound() {
        this.presenter = new JourneyOutputBoundary() {
            @Override
            public void prepareSuccessView(JourneyOutputData outputData) {

            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertTrue(errorMessage.equals("No matching result!"));
            }
        };

        ArrayList<String> parentChildren = new ArrayList<>();
        parentChildren.add("United States");
        Node parent = Node.createNode("Canada", "blah", null, parentChildren, true);
        journeyDAO.setRootNode(parent);

        JourneyInputData inputData = new JourneyInputData("/wiki/argoloid");
        JourneyInteractor interactor = new JourneyInteractor(searchDAO, journeyDAO, presenter);

        interactor.execute(inputData);
    }

    @Test
    void badRequest() {
        this.presenter = new JourneyOutputBoundary() {
            @Override
            public void prepareSuccessView(JourneyOutputData outputData) {

            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertTrue(errorMessage.equals("Bad Wiki Request Exception"));
            }
        };

        ArrayList<String> parentChildren = new ArrayList<>();
        parentChildren.add("United States");
        Node parent = Node.createNode("Canada", "blah", null, parentChildren, true);
        journeyDAO.setRootNode(parent);

        JourneyInputData inputData = new JourneyInputData("/wiki/Special:Search/intitle:%22Any%22");
        JourneyInteractor interactor = new JourneyInteractor(searchDAO, journeyDAO, presenter);

        interactor.execute(inputData);
    }

    @Test
    void goodRequest() {
        this.presenter = new JourneyOutputBoundary() {
            @Override
            public void prepareSuccessView(JourneyOutputData outputData) {
                assertTrue(outputData.getTitle().equals("United States"));
            }

            @Override
            public void prepareFailView(String errorMessage) {

            }
        };

        ArrayList<String> parentChildren = new ArrayList<>();
        parentChildren.add("United States");
        Node parent = Node.createNode("Canada", "blah", null, parentChildren, true);
        journeyDAO.setRootNode(parent);

        JourneyInputData inputData = new JourneyInputData("/wiki/United_States");
        JourneyInteractor interactor = new JourneyInteractor(searchDAO, journeyDAO, presenter);

        interactor.execute(inputData);
    }
}
