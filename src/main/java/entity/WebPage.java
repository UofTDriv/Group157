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

        // Remove table tags + friends and their content
        // note: this might be a bit aggressive, but we're working with HTML 3.2 here theres not a ton of ways
        // to make things work correctly, so aggressive is how we gotta be ig -scott
        // TODO: remove this comment
        rawHtml = rawHtml.replaceAll("(?s)<table.*?>.*?</table>", "");
        rawHtml = rawHtml.replaceAll("(?s)<td.*?>.*?</td>", "");
        rawHtml = rawHtml.replaceAll("(?s)<tr.*?>.*?</tr>", "");
        rawHtml = rawHtml.replaceAll("(?s)<th.*?>.*?</th>", "");

        // see above
        // remove everything after the references
        if (rawHtml.contains("<h2 id=\"References\">")) {
            rawHtml = rawHtml.split("(?s)<h2 id=\"References\">")[0];
        }

        // remove the little superscript references
        rawHtml = rawHtml.replaceAll("(?s)<sup id=\".*?\" class=\"reference\">.*?</sup>", "");

        // wrap in wrapper div
        rawHtml = "<div class=\"java-content-wrapper\">" + rawHtml + "</div>";

        // prepend styles
        rawHtml = styles + rawHtml;

        // Return the cleaned HTML
        return rawHtml;
    }

    // i've minified this, but it basically just makes the wikipedia pages marginally more readable
    public static String styles = "<style>:root{font-size:16px;}.java-content-wrapper{color:#ebeefa;font:" +
                                    "sans-serif !important;}a{text-decoration:none;color:#52dad8}</style>";
}
