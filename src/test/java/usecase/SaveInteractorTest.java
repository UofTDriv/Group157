package usecase;

import data_access.InMemoryJourneyDataAccessInterface;
import data_access.InMemorySaveDataAccessObject;
import entity.Node;
import entity.WebPage;
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

        // TODO fix this test
//        journeyDAO.setRootNode(new WebPage("Canada", "Blah blah blah"));

//        SaveInputData inputData = new SaveInputData("close", "Canada Hole");
//        SaveInteractor interactor = new SaveInteractor(presenter, saveDAO, journeyDAO);
//
//        interactor.execute(inputData);
//
//        SaveInputData inputData2 = new SaveInputData("close", "Canada Bowl");
//        journeyDAO.setRootPage(new WebPage("Cthis.journey = journey + \": \" + currentPage;anada", "Blah blah blah"));
//        interactor.execute(inputData2);
//        System.out.println(saveDAO.wikiHistoryExists("Canada Hole"));
    }
}
