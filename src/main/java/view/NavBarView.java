package view;

import interface_adapter.navBar.NavBarController;
import interface_adapter.navBar.NavBarState;
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

        search = SwingStyle.makeTab(viewModel.getState().getSearch());

        search.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.switchToSearchView();
                }
            }
        );

        save = SwingStyle.makeTab(viewModel.getState().getSave());
        save.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.switchToSaveView();
                }
            }
        );

        open = SwingStyle.makeTab(viewModel.getState().getOpen());
        open.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.switchToOpenView();
                }
            }
        );

        journey = SwingStyle.makeTab(viewModel.getState().getJourney());
        journey.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.switchToJourneyView();
                    }
                }
        );

        graph = SwingStyle.makeTab(viewModel.getState().getGraph());
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final NavBarState state = (NavBarState) evt.getNewValue();
            save.setText(state.getSave());
            journey.setText(state.getJourney());
            graph.setText(state.getGraph());
        } else if (evt.getPropertyName().equals("error")) {
            final NavBarState state = (NavBarState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, state.getSwitchError());
        }
    }

    public void setController(NavBarController controller) {
        this.controller = controller;
    }

}