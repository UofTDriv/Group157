package use_case.journey;

import entity.Node;
import entity.WebPage;
import use_case.search.SearchDataAccessInterface;
import use_case.search.SearchOutputData;

import java.util.ArrayList;

public class JourneyInteractor implements JourneyInputBoundary {
    private final SearchDataAccessInterface searchAccessObject;
    private final JourneyDataAccessInterface journeyAccessObject;
    private final JourneyOutputBoundary presenter;

    public JourneyInteractor(SearchDataAccessInterface searchAccessObject,
                             JourneyDataAccessInterface journeyAccessObject,
                             JourneyOutputBoundary presenter) {
        this.searchAccessObject = searchAccessObject;
        this.journeyAccessObject = journeyAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute(JourneyInputData inputData) {
        String subject = inputData.getSubject();
        if(!searchAccessObject.pageExists(subject)) {
            presenter.prepareFailView("No matching result!");
        }
        else {
            String content = cleanWikipediaHTML(searchAccessObject.getHTML(subject));
            WebPage newPage = new WebPage(searchAccessObject.getTitle(subject),content);

            Node newNode = new Node(newPage, journeyAccessObject.getJourney().getCurrentNode());

            journeyAccessObject.addNode(newNode);

            JourneyOutputData outputData = new JourneyOutputData(newNode.getPage());

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

}
