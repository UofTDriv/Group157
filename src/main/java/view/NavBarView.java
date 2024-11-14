package view;

import interface_adapter.NavBarViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NavBarView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "Top Navigation Bar";
    private final NavBarViewModel navBarViewModel;

    private final JButton search;
    private final JButton save;
    private final JButton openOrCurrent;
    private final JButton graph;
    private final JButton timeline;

    public NavBarView(NavBarViewModel navBarViewModel) {
        this.navBarViewModel = navBarViewModel;
        navBarViewModel.addPropertyChangeListener(this);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.2;

        search = new JButton(navBarViewModel.getSearch());
        c.gridx = 0;
        this.add(search, c);

        save = new JButton(navBarViewModel.getSave());
        c.gridx = 1;
        this.add(save, c);

        openOrCurrent = new JButton(navBarViewModel.getOpenOrCurrent());
        c.gridx = 2;
        this.add(openOrCurrent, c);

        graph = new JButton(navBarViewModel.getGraph());
        c.gridx = 3;
        this.add(graph, c);

        timeline = new JButton(navBarViewModel.getTimeline());
        c.gridx = 4;
        this.add(timeline, c);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // TODO: add functionality to the navbar to change the text of openOrCurrent and
    }
}