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

        JLabel toptext = SwingStyle.makeHeading(SaveViewModel.TOPTEXT_LABEL);

        final JPanel saveInput = new JPanel();
        saveInput.setLayout(new GridLayout(2, 2));
        saveInput.setMaximumSize(new Dimension(600, 150));
        saveInput.setOpaque(false);

        JLabel inputTitle = SwingStyle.makeLabel(SaveViewModel.INPUT_TITLE_LABEL);
//        inputTitle.setMaximumSize(inputTitle.getPreferredSize());
        saveInput.add(inputTitle);

        this.savedJourneyTitle = SwingStyle.makeTextField(20);
        saveInput.add(savedJourneyTitle);

        saveInput.add(SwingStyle.makeLabel(SaveViewModel.ROOT));

        this.rootArticleTitle = SwingStyle.makeLabel(viewModel.getState().getRootArticleTitle());
        saveInput.add(rootArticleTitle);
//        saveInput.setMaximumSize(saveInput.getPreferredSize());

        this.saveAndContinueButton = SwingStyle.makeButton(SaveViewModel.SAVE_AND_CONTINUE_BUTTON_LABEL);
        this.saveAndCloseButton = SwingStyle.makeButton(SaveViewModel.SAVE_AND_CLOSE_BUTTON_LABEL);

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

        saveAndCloseButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(saveAndCloseButton)) {
                            saveController.execute("close", savedJourneyTitle.getText());
                        }
                    }
                }
        );

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(saveAndContinueButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0))); // padding!
        buttonPanel.add(saveAndCloseButton);
        buttonPanel.setOpaque(false);

        StandardMenuPanel.standardUI(this, toptext, saveInput, buttonPanel);

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
