package use_case.search;

import entity.Node;
import entity.WebPage;
import use_case.journey.JourneyDataAccessInterface;

import java.util.ArrayList;

/**
 * Interactor for the search function.
 */
public class SearchInteractor implements SearchInputBoundary {
    private final SearchDataAccessInterface searchAccessObject;
    private final JourneyDataAccessInterface journeyAccessObject;
    private final SearchOutputBoundary presenter;

    public SearchInteractor(SearchOutputBoundary presenter, SearchDataAccessInterface searchAccessObject, JourneyDataAccessInterface journeyAccessObject) {
        this.searchAccessObject = searchAccessObject;
        this.journeyAccessObject = journeyAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute(SearchInputData inputData) {
        String subject = inputData.getSubject();
        if(!searchAccessObject.pageExists(subject)) {
            presenter.prepareFailView("No matching result!");
        }
        else {
            String title = searchAccessObject.getTitle(subject);
            String content = WebPage.cleanWikipediaHTML(searchAccessObject.getHTML(subject));
            WebPage rootPage = new WebPage(title, content);
            ArrayList<String> links = searchAccessObject.getPageLinks(subject);

            Node root = new Node(rootPage, null, links,true);

            journeyAccessObject.setRootNode(root);

            SearchOutputData outputData = new SearchOutputData(rootPage, false);
            presenter.prepareSuccessView(outputData);
        }
    }

    private String cleanWikipediaHTML(String rawHtml) {
        // Remove script tags and their content
        rawHtml = rawHtml.replaceAll("(?s)<script.*?>.*?</script>", "");

        // Remove style tags and their content
        rawHtml = rawHtml.replaceAll("(?s)<style.*?>.*?</style>", "");

        // Remove img tags
        rawHtml = rawHtml.replaceAll("<img.*?>", "");

        // Remove comments
        rawHtml = rawHtml.replaceAll("(?s)<!--.*?-->", "");

        // Remove 'edit' sections (spans with class 'mw-editsection')
        rawHtml = rawHtml.replaceAll("(?s)<span[^>]*class=\"[^\"]*mw-editsection[^\"]*\"[^>]*>.*?</span>", "");
        rawHtml = rawHtml.replaceAll("(?s)<a[^>]*href=\"[^\"]*action=edit[^\"]*\"[^>]*>.*?</a>", "");
        rawHtml = rawHtml.replaceAll("(?s)<a[^>]*title=\"[^\"]*Edit section[^\"]*\"[^>]*>.*?</a>", "");

        // Remove unnecessary elements by their class or id attributes
        rawHtml = rawHtml.replaceAll("(?s)<(div|table)[^>]*class=\"[^\"]*?(infobox|toc|navbox|reflist|reference|mw-editsection)[^\"]*\"[^>]*>.*?</\\1>", "");
        rawHtml = rawHtml.replaceAll("(?s)<div[^>]*id=\"(footer|mw-footer)\"[^>]*>.*?</div>", "");

        // Remove inline styles
        rawHtml = rawHtml.replaceAll("(?i) style=\"[^\"]*\"", "");

        // Remove event handler attributes like onclick
        rawHtml = rawHtml.replaceAll("(?i) on\\w+=\"[^\"]*\"", "");

        // Clean up empty tags that might have been left behind
        rawHtml = rawHtml.replaceAll("<\\w+\\s*/>", "");

        // Return the cleaned HTML
        return rawHtml;
    }

    // TODO put this function somewhere universal to stop repeat in JourneyInteractor.java
}
