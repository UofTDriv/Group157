package view;

import interface_adapter.save.SaveController;
import interface_adapter.save.SaveState;
import interface_adapter.save.SaveViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchState;

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

    final JButton saveAndContinueButton;
    final JButton saveAndCloseButton;

    private SaveController saveController;

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

        this.savedJourneyTitle = new JTextField(20);
        savedJourneyTitle.setMaximumSize(savedJourneyTitle.getPreferredSize());
        saveInput.add(savedJourneyTitle);

        saveInput.add(new JLabel(SaveViewModel.ROOT));

        this.rootArticleTitle = new JLabel(viewModel.getState().getRootArticleTitle());
        saveInput.add(rootArticleTitle);
        saveInput.setMaximumSize(saveInput.getPreferredSize());

        this.saveAndContinueButton = new JButton(SaveViewModel.SAVE_AND_CONTINUE_BUTTON_LABEL);
        this.saveAndCloseButton = new JButton(SaveViewModel.SAVE_AND_CLOSE_BUTTON_LABEL);

        StandardMenuPanel.standardUI(this, toptext, saveInput, saveAndContinueButton);
        saveAndContinueButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(saveAndContinueButton)) {
                            final SaveState currentState = viewModel.getState();

                            saveController.execute("continue", savedJourneyTitle.getText());
                        }
                    }
                }
        );

        StandardMenuPanel.standardUI(this, toptext, saveInput, saveAndCloseButton);
        saveAndCloseButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(saveAndCloseButton)) {
                            final SaveState currentState = viewModel.getState();

                            saveController.execute("close", savedJourneyTitle.getText());
                        }
                    }
                }
        );
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

    public void setSaveController(SaveController saveController) {
        this.saveController = saveController;
    }
}
