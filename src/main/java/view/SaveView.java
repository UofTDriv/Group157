package view;

import interface_adapter.save.SaveViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SaveView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName;
    private final SaveViewModel viewModel;

    final JTextField savedJourneyTitle;

    final JButton saveButton;

    public SaveView(SaveViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);

        JLabel toptext = new JLabel(SaveViewModel.TOPTEXT_LABEL);
        toptext.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel saveInput = new JPanel();
        saveInput.setLayout(new GridLayout(2, 2));

        JLabel inputTitle = new JLabel(SaveViewModel.INPUT_TITLE_LABEL);
        inputTitle.setMaximumSize(inputTitle.getPreferredSize());
        saveInput.add(inputTitle);

        this.savedJourneyTitle  = new JTextField(20);
        savedJourneyTitle.setMaximumSize(savedJourneyTitle.getPreferredSize());
        saveInput.add(savedJourneyTitle);

        saveInput.add(new JLabel(SaveViewModel.ROOT));
        saveInput.add(new JLabel(viewModel.getState().getRootArticleTitle()));

        saveInput.setMaximumSize(saveInput.getPreferredSize());
        saveInput.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.saveButton = new JButton(SaveViewModel.SAVE_BUTTON_LABEL);
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(toptext);
        this.add(Box.createVerticalStrut(30));
        this.add(saveInput);
        this.add(Box.createVerticalStrut(20));
        this.add(saveButton);
        this.add(Box.createVerticalGlue());
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
