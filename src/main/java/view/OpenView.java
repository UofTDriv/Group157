package view;

import interface_adapter.open.OpenController;
import interface_adapter.open.OpenState;
import interface_adapter.open.OpenViewModel;
import interface_adapter.save.SaveState;

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

    private final JLabel toptext;
    private final JPanel saves;

    private OpenController openController;

    public OpenView(OpenViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);

        this.toptext = SwingStyle.makeHeading(OpenViewModel.INFO_LABEL);

        this.saves = new JPanel();
        saves.setLayout(new BoxLayout(saves, BoxLayout.Y_AXIS));
        saves.setOpaque(false);

        openLast = SwingStyle.makeAccentButton("Open Last");

        // TODO add a for loop that iterates through the list of saved Journeys however we did that
        StandardMenuPanel.standardUI(this, toptext, saves, openLast);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final OpenState state = (OpenState) evt.getNewValue();
            String saveTitle = state.getWikiHistoryNodes().get(state.getWikiHistoryNodes().size() - 1).getFirst();
            JButton newSave = SwingStyle.makeButton(saveTitle);
            saves.add(newSave);
            saves.add(Box.createRigidArea(new Dimension(0, 10)));
            newSave.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            openController.execute(newSave.getText());
                        }
                    }
            );
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setOpenController(OpenController openController) { this.openController = openController; }
}
