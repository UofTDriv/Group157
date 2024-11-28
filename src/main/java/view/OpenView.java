package view;

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

    public OpenView(OpenViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);

        this.toptext = new JLabel(OpenViewModel.INFO_LABEL);

        this.saves = new JPanel();
        saves.setLayout(new BoxLayout(saves, BoxLayout.Y_AXIS));

        openLast = new JButton("Open Last: ");

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
//            rootArticleTitle.setText(state.getRootArticleTitle());
            String saveTitle = state.getWikiHistoryNodes().get(state.getWikiHistoryNodes().size() - 1).getFirst();
            JButton newSave = new JButton(saveTitle);

//            StandardMenuPanel.standardUI(this, toptext, saves, newSave);
            saves.add(newSave);
        }
    }

    public String getViewName() {
        return viewName;
    }
}
