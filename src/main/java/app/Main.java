package app;

import data_access.InMemoryJourneyDataAccessInterface;
import data_access.WikipediaAccessObject;
import use_case.search.SearchDataAccessInterface;

import javax.swing.*;

/**
 * The Main class of our application.
 */
public class Main {
    public static void main(String[] args) {

        final SearchDataAccessInterface searchAccessObj = new WikipediaAccessObject();
        final InMemoryJourneyDataAccessInterface journeyAccessObj = new InMemoryJourneyDataAccessInterface();

        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                .addSearchDAO(searchAccessObj)
                .addMemoryDAO(journeyAccessObj)
                .addNavBarView()
                .addSearchView()
                .addJourneyView()
                .addSaveView()
                .addOpenView()
                .addGraphView()
                .addNavBarUseCase()
                .addSearchUseCase()
                .addJourneyUseCase()
                .build();
        application.pack();
        application.setVisible(true);
    }
}
