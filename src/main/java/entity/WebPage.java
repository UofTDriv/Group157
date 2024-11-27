package entity;

/**
 * Stores the data representing a webpage.
 */
public class WebPage {

    public final String title;
    public final String content;

    public WebPage(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static String cleanWikipediaHTML(String rawHtml) {
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
