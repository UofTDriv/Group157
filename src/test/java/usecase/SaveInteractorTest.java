package usecase;

import data_access.InMemoryJourneyDataAccessInterface;
import data_access.InMemorySaveDataAccessObject;
import data_access.WikipediaAccessObject;
import entity.WebPage;
import interface_adapter.save.SavePresenter;
import org.junit.jupiter.api.Test;
import use_case.journey.JourneyDataAccessInterface;
import use_case.save.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveInteractorTest {
    @Test
    void test1() {
        SaveDataAccessInterface saveDAO = new InMemorySaveDataAccessObject();
        SaveOutputBoundary presenter = new SaveOutputBoundary() {
            @Override
            public void prepareSuccessViewContinue(SaveOutputData saveOutputData) {

            }

            @Override
            public void prepareFailViewContinue(String errorMessage) {

            }

            @Override
            public void prepareSuccessViewClose(SaveOutputData saveOutputData) {
                assertTrue(saveOutputData.getMessage().equals("Canada Hole has been added"));
            }

            @Override
            public void prepareFailViewClose(String errorMessage) {

            }
        };

        JourneyDataAccessInterface journeyDAO = new InMemoryJourneyDataAccessInterface();
        journeyDAO.setRootPage(new WebPage("Canada", "Blah blah blah"));

        SaveInputData inputData = new SaveInputData("close", "Canada Hole");
        SaveInteractor interactor = new SaveInteractor(presenter, saveDAO, journeyDAO);

        interactor.execute(inputData);
        System.out.println(saveDAO.wikiHistoryExists("Canada Hole"));
    }
}
