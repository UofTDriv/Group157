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

    public OpenView(OpenViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);

        this.setLayout(new BorderLayout());
        this.setAlignmentX(CENTER_ALIGNMENT);
        final JLabel toptext = new JLabel(OpenViewModel.INFO_LABEL);
        toptext.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(toptext, BorderLayout.NORTH);

//        JPanel saveList = new JPanel(new BoxLayout(this, BoxLayout.Y_AXIS));
        // TODO add a for loop that iterates through the list of saved Journeys however we did that
//        this.add(saveList, BorderLayout.CENTER);
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
