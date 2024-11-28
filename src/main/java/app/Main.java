package app;

import data_access.InMemoryJourneyDataAccessObject;
import data_access.InMemorySaveDataAccessObject;
import data_access.WikipediaAccessObject;
import use_case.save.SaveDataAccessInterface;
import use_case.search.SearchDataAccessInterface;

import javax.swing.*;

/**
 * The Main class of our application.
 */
public class Main {
    public static void main(String[] args) {

        final SearchDataAccessInterface searchAccessObj = new WikipediaAccessObject();
        final InMemoryJourneyDataAccessObject journeyAccessObj = new InMemoryJourneyDataAccessObject();
        final SaveDataAccessInterface saveAccessObj = new InMemorySaveDataAccessObject();

        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                .addSearchDAO(searchAccessObj)
                .addMemoryDAO(journeyAccessObj)
                .addSaveDAO(saveAccessObj)
                .addNavBarView()
                .addSearchView()
                .addJourneyView()
                .addSaveView()
                .addOpenView()
                .addGraphView()
                .addAddUseCase()
                .addGraphUseCase()
                .addSearchUseCase()
                .addJourneyUseCase()
                .addSaveUseCase()
                .addNavBarUseCase()
                .build();
        application.pack();
        application.setVisible(true);
    }
}
