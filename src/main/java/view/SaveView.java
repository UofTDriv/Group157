package view;

import interface_adapter.save.SaveState;
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
    final JLabel rootArticleTitle;

    final JButton saveButton;

    public SaveView(SaveViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);

        JLabel toptext = new JLabel(SaveViewModel.TOPTEXT_LABEL);

        final JPanel saveInput = new JPanel();
        saveInput.setLayout(new GridLayout(2, 2));

        JLabel inputTitle = new JLabel(SaveViewModel.INPUT_TITLE_LABEL);
        inputTitle.setMaximumSize(inputTitle.getPreferredSize());
        saveInput.add(inputTitle);

        this.savedJourneyTitle  = new JTextField(20);
        savedJourneyTitle.setMaximumSize(savedJourneyTitle.getPreferredSize());
        saveInput.add(savedJourneyTitle);

        saveInput.add(new JLabel(SaveViewModel.ROOT));

        this.rootArticleTitle = new JLabel(viewModel.getState().getRootArticleTitle());
        saveInput.add(rootArticleTitle);
        saveInput.setMaximumSize(saveInput.getPreferredSize());

        this.saveButton = new JButton(SaveViewModel.SAVE_BUTTON_LABEL);

        StandardMenuPanel.standardUI(this, toptext, saveInput, saveButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final SaveState state = (SaveState) evt.getNewValue();
            rootArticleTitle.setText(state.getRootArticleTitle());
        }
    }

    public String getViewName() {
        return viewName;
    }
}
