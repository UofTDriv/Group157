package use_case.graph;

import entity.Node;
import entity.WebPage;


/**
 * Input data for the graph use case.
 */
public class GraphInputData {

    private final String subject;

    public GraphInputData(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }
}
