package view;

import interface_adapter.journey.JourneyState;
import interface_adapter.journey.JourneyViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JourneyView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName;
    private final JourneyViewModel viewModel;

    private final JEditorPane articleContent;
    // TODO figure out how to add a persistant graph view
    // private final GraphView graphViewPLACEHOLDER;

    private final JCheckBox addNewPages;
    private final JButton addPage;

    public JourneyView(JourneyViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(0,0,0,0);

        this.articleContent = new JEditorPane();
        articleContent.setEditable(false);
        articleContent.setContentType("text/html");
        articleContent.setText(viewModel.getState().getCurrentPageContent());

        gbc.gridwidth = 3;
        gbc.ipady = 100;
        gbc.gridy = 0;
        gbc.gridx = 0;
        this.add(articleContent, gbc);

        // GraphPlaceHolder
//        JPanel graphViewFrame = new JPanel();
//        graphViewFrame.setOpaque(true);
//        graphViewFrame.setBackground(Color.BLACK);
//        gbc.gridwidth = 2;
//        gbc.gridheight = 2;
//        gbc.gridy = 0;
//        gbc.gridx = 3;
//        this.add(graphViewFrame, gbc);

        this.addNewPages = new JCheckBox(JourneyViewModel.ADDPAGES_CHECK_LABEL);
        this.addNewPages.setSelected(viewModel.getState().isAddNewPages());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(addNewPages, gbc);

        this.addPage = new JButton(JourneyViewModel.ADDPAGE_BUTTON_LABEL);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(addPage, gbc);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            articleContent.setText(viewModel.getState().getCurrentPageContent());
        }
    }

    public String getViewName() {
        return viewName;
    }
}
