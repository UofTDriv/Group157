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
    private final JButton open;
    private final JButton journey;
    private final JButton graph;

//    private final JButton timeline;

    public NavBarView(NavBarViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.2;

        search = new JButton(viewModel.getState().getSearch());

        search.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.switchToSearchView();
                }
            }
        );

        save = new JButton(viewModel.getState().getSave());
        save.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.switchToSaveView();
                }
            }
        );

        open = new JButton(viewModel.getState().getOpen());
        open.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.switchToOpenView();
                }
            }
        );

        journey = new JButton(viewModel.getState().getJourney());
        journey.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.switchToJourneyView();
                    }
                }
        );

        graph = new JButton(viewModel.getState().getGraph());
        graph.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.switchToGraphView();
                }
            }
        );

        JButton[] buttons = new JButton[]{search, save, open, journey, graph};
        for (int i = 0; i < 5; i++) {
            c.gridx = i;
            this.add(buttons[i], c);
        }

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
        // TODO: add functionality to the navbar to change the text of journey and save
    }

    public void setController(NavBarController controller) {
        this.controller = controller;
    }

}