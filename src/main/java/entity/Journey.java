package entity;

import java.util.List;

public class Journey {
    public final List<Node> pages;
    public final String rootPage;

    public Journey(List<Node> pages, String rootPage) {
        this.pages = pages;
        this.rootPage = rootPage;
    }
}
