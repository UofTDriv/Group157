package view;

import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "log in";
    private final SearchViewModel searchViewModel;

    private final JTextField titleInputField;

    private final JButton searchButton;

    public SearchView(SearchViewModel searchViewModel) {
        this.searchViewModel = searchViewModel;
        this.searchViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel toptext = new JLabel(SearchViewModel.TOPTEXT_LABEL);
        toptext.setAlignmentX(Component.CENTER_ALIGNMENT);
        toptext.setFont(new Font("Times New Roman", Font.BOLD, 36));

        final JLabel searchInfo = new JLabel(SearchViewModel.INFO);
        searchInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.titleInputField = new JTextField(15);
        titleInputField.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleInputField.setMaximumSize(titleInputField.getPreferredSize());


        this.searchButton = new JButton(SearchViewModel.SEARCH_BUTTON_LABEL);
        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createVerticalGlue());
        this.add(toptext);
        this.add(searchInfo);
        this.add(Box.createVerticalStrut(30));
        this.add(titleInputField);
        this.add(Box.createVerticalStrut(20));
        this.add(searchButton);
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
