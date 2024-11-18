package view;

import interface_adapter.navBar.NavBarController;
import interface_adapter.navBar.NavBarViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NavBarView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName;
    private final NavBarViewModel viewModel;

    private NavBarController controller;

    private final JButton search;
    private final JButton save;
    private final JButton openOrCurrent;
    private final JButton graph;
//    private final JButton timeline;

    public NavBarView(NavBarViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
//        c.weightx = 0.2;
        c.weightx = 0.25;

        search = new JButton(viewModel.getState().getSearch());
        c.gridx = 0;

        search.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.switchToSearchView();
                }
            }
        );

        this.add(search, c);

        save = new JButton(viewModel.getState().getSave());
        c.gridx = 1;
        save.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.switchToSaveView();
                }
            }
        );
        this.add(save, c);

        openOrCurrent = new JButton(viewModel.getState().getOpenOrCurrent());
        c.gridx = 2;
        openOrCurrent.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.switchToOpenView();
                }
            }
        );
        this.add(openOrCurrent, c);

        graph = new JButton(viewModel.getState().getGraph());
        c.gridx = 3;
        graph.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.switchToGraphView();
                }
            }
        );
        this.add(graph, c);

//        timeline = new JButton(viewModel.getState().getTimeline());
//        c.gridx = 4;
//        this.add(timeline, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // TODO: add functionality to the navbar to change the text of openOrCurrent and save
    }

    public void setController(NavBarController controller) {
        this.controller = controller;
    }

}