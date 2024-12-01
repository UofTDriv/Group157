package usecase;

import data_access.InMemoryJourneyDataAccessObject;
import data_access.InMemorySaveDataAccessObject;
import entity.Node;
import entity.WebPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.journey.JourneyDataAccessInterface;
import use_case.save.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveInteractorTest {

    public SaveDataAccessInterface saveDAO;
    public SaveOutputBoundary presenter;
    public JourneyDataAccessInterface journeyDAO;

    @BeforeEach
    public void setUp() {
        this.saveDAO = new InMemorySaveDataAccessObject();
        this.journeyDAO = new InMemoryJourneyDataAccessObject();
    }

    @Test
    void hasBeenAddedClose() {
        this.presenter = new SaveOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveOutputData saveOutputData) {
                assertTrue(saveOutputData.getMessage().equals(saveOutputData.getSaveTitle() + " has been added"));
            }

            @Override
            public void prepareFailView(String errorMessage) {

            }
        };

        ArrayList<String> parentChildren = new ArrayList<>();
        parentChildren.add("United States");
        Node parent = Node.createNode("Canada", "blah", null, parentChildren, true);
        journeyDAO.setRootNode(parent);
        Node node1 = Node.createNode("United States", "blah", parent, null, true);

        SaveInputData inputData = new SaveInputData("close", "A");
        SaveInteractor interactor = new SaveInteractor(presenter, presenter, saveDAO, journeyDAO);

        interactor.execute(inputData);
    }

    @Test
    void hasBeenAddedContinue() {
        this.presenter = new SaveOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveOutputData saveOutputData) {
                assertTrue(saveOutputData.getMessage().equals(saveOutputData.getSaveTitle() + " has been added"));
            }

            @Override
            public void prepareFailView(String errorMessage) {

            }
        };

        ArrayList<String> parentChildren = new ArrayList<>();
        parentChildren.add("United States");
        Node parent = Node.createNode("Canada", "blah", null, parentChildren, true);
        journeyDAO.setRootNode(parent);
        Node node1 = Node.createNode("United States", "blah", parent, null, true);

        SaveInputData inputData = new SaveInputData("continue", "A");
        SaveInteractor interactor = new SaveInteractor(presenter, presenter, saveDAO, journeyDAO);

        interactor.execute(inputData);
    }

    @Test
    void alreadySavedClose() {
        this.presenter = new SaveOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveOutputData saveOutputData) {

            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertTrue(errorMessage.equals("You've already saved this history"));
            }
        };

        ArrayList<String> parentChildren = new ArrayList<>();
        parentChildren.add("United States");
        Node parent = Node.createNode("Canada", "blah", null, null, true);
        journeyDAO.setRootNode(parent);


        SaveInputData inputData = new SaveInputData("close", "A");
        SaveInteractor interactor = new SaveInteractor(presenter, presenter, saveDAO, journeyDAO);
        interactor.execute(inputData);

        Node parent2 = Node.createNode("Canada", "blah", null, null, true);
        journeyDAO.setRootNode(parent2);

        SaveInputData inputData2 = new SaveInputData("close", "B");
        interactor.execute(inputData2);

    }

    @Test
    void alreadySavedContinue() {
        this.presenter = new SaveOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveOutputData saveOutputData) {

            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertTrue(errorMessage.equals("You've already saved this history"));
            }
        };

        ArrayList<String> parentChildren = new ArrayList<>();
        parentChildren.add("United States");
        Node parent = Node.createNode("Canada", "blah", null, null, true);
        journeyDAO.setRootNode(parent);


        SaveInputData inputData = new SaveInputData("continue", "A");
        SaveInteractor interactor = new SaveInteractor(presenter, presenter, saveDAO, journeyDAO);
        interactor.execute(inputData);

        Node parent2 = Node.createNode("Canada", "blah", null, null, true);
        journeyDAO.setRootNode(parent2);

        SaveInputData inputData2 = new SaveInputData("continue", "B");
        interactor.execute(inputData2);
    }

    @Test
    void byThatNameClose() {
        this.presenter = new SaveOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveOutputData saveOutputData) {

            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertTrue(errorMessage.equals("History by that name already exists"));
            }
        };

        Node parent = Node.createNode("Canada", "blah", null, null, true);
        journeyDAO.setRootNode(parent);

        SaveInputData inputData = new SaveInputData("close", "A");
        SaveInteractor interactor = new SaveInteractor(presenter, presenter, saveDAO, journeyDAO);

        interactor.execute(inputData);

        Node parent2 = Node.createNode("United States", "blah", null, null, true);
        journeyDAO.setRootNode(parent2);

        SaveInputData inputData2 = new SaveInputData("close", "A");
        interactor.execute(inputData2);

    }

    @Test
    void byThatNameContinue() {
        this.presenter = new SaveOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveOutputData saveOutputData) {

            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertTrue(errorMessage.equals("History by that name already exists"));
            }
        };

        Node parent = Node.createNode("Canada", "blah", null, null, true);
        journeyDAO.setRootNode(parent);

        SaveInputData inputData = new SaveInputData("close", "A");
        SaveInteractor interactor = new SaveInteractor(presenter, presenter, saveDAO, journeyDAO);

        interactor.execute(inputData);

        Node parent2 = Node.createNode("United States", "blah", null, null, true);
        journeyDAO.setRootNode(parent2);

        SaveInputData inputData2 = new SaveInputData("continue", "A");
        interactor.execute(inputData2);
    }


}
