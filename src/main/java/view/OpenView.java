package view;

import interface_adapter.open.OpenViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OpenView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName;
    private final OpenViewModel viewModel;

    private final JButton openLast;

    public OpenView(OpenViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);

        final JLabel toptext = new JLabel(OpenViewModel.INFO_LABEL);

        JPanel saves = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;

        JButton niy = new JButton("Not implemented yet");
        saves.add(niy, c);
        saves.setMaximumSize(new Dimension(Integer.MAX_VALUE, niy.getPreferredSize().height));

        openLast = new JButton("Open Last: ");

        // TODO add a for loop that iterates through the list of saved Journeys however we did that
        StandardMenuPanel.standardUI(this, toptext, saves, openLast);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public String getViewName() {
        return viewName;
    }
}
