package view;

import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName;
    private final SearchViewModel viewModel;

    private final JTextField titleInputField;

    private final JButton searchButton;

    public SearchView(SearchViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);

        final JLabel toptext = new JLabel(SearchViewModel.TOPTEXT_LABEL);
        toptext.setFont(new Font("Times New Roman", Font.BOLD, 36));

        this.titleInputField = new JTextField(15);
        titleInputField.setText(SearchViewModel.INFO);

        this.searchButton = new JButton(SearchViewModel.SEARCH_BUTTON_LABEL);

        this.add(new StandardMenuPanel(toptext, titleInputField, searchButton));

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
