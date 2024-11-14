package view;

import interface_adapter.save.SaveViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SaveView extends JPanel implements ActionListener, PropertyChangeListener {
    private final SaveViewModel viewModel;

    final JTextField savedJourneyTitle;

    final JButton saveButton;

    public SaveView(SaveViewModel viewModel) {
        this.viewModel = viewModel;

        this.setLayout(new BorderLayout());

        this.add(new JLabel(SaveViewModel.INFO_LABEL), BorderLayout.NORTH);

        final JPanel saveInput = new JPanel();
        saveInput.setLayout(new GridLayout(2, 2));

        saveInput.add(new JLabel(SaveViewModel.INPUT_TITLE_LABEL));

        this.savedJourneyTitle  = new JTextField(20);
        savedJourneyTitle.setMaximumSize(savedJourneyTitle.getPreferredSize());

        saveInput.add(savedJourneyTitle);
        saveInput.add(new JLabel(SaveViewModel.ROOT));
        saveInput.add(new JLabel(viewModel.getState().getRootArticleTitle()));

        this.add(saveInput, BorderLayout.CENTER);

        final JPanel saveButtonPanel = new JPanel();
        saveButtonPanel.setLayout(new BoxLayout(saveButtonPanel, BoxLayout.Y_AXIS));
        this.saveButton = new JButton(SaveViewModel.SAVE_BUTTON_LABEL);
        saveButtonPanel.add(saveButton);

        this.add(saveButtonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
