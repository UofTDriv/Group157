package view;

import entity.WebPage;
import interface_adapter.NavBarViewModel;
import interface_adapter.journey.JourneyViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JourneyView extends JPanel implements ActionListener, PropertyChangeListener {
    private final JourneyViewModel journeyViewModel;

    private final JEditorPane articleContent;
    private final JLabel graphViewPlaceholder;
    // TODO not sure how to add a persistent graph

    private final JCheckBox addNewPages;
    private final JButton addPage;

    public JourneyView(JourneyViewModel journeyViewModel) {
        this.journeyViewModel = journeyViewModel;

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.2;
        gbc.gridy = 0;
        gbc.gridx = 0;

        this.articleContent = new JEditorPane();
        articleContent.setEditable(false);
        articleContent.setContentType("text/html");
        articleContent.setBackground(Color.BLUE);
        articleContent.setSize(100, 100);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(articleContent, gbc);

        this.graphViewPlaceholder = new JLabel();
        graphViewPlaceholder.setOpaque(true);
        graphViewPlaceholder.setBackground(Color.BLACK);
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.gridy = 1;
        gbc.gridx = 3;
        this.add(graphViewPlaceholder, gbc);

        this.addNewPages = new JCheckBox(JourneyViewModel.ADDPAGES_CHECK_LABEL);
        this.addNewPages.setSelected(journeyViewModel.getState().isAddNewPages());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(addNewPages, gbc);

        this.addPage = new JButton(JourneyViewModel.ADDPAGE_BUTTON_LABEL);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(addPage, gbc);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
