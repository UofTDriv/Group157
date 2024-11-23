package view;

import interface_adapter.search.SearchController;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName;

    private final SearchViewModel viewModel;
    private final JTextField titleInputField = new JTextField(20);

    private SearchController searchController;

    private final JButton searchButton;

    public SearchView(SearchViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);

        final JLabel toptext = new JLabel(SearchViewModel.TOPTEXT_LABEL);
        toptext.setFont(new Font("Times New Roman", Font.BOLD, 36));

        //final JLabel info = new JLabel(SearchViewModel.INFO);
        titleInputField.setMaximumSize(titleInputField.getPreferredSize());

        this.searchButton = new JButton(SearchViewModel.SEARCH_BUTTON_LABEL);
        searchButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(searchButton)) {
                            final SearchState currentState = viewModel.getState();

                            searchController.execute(currentState.getTitle());
                        }
                    }
                }
        );

        addSearchListener();

        StandardMenuPanel.standardUI(this, toptext, titleInputField, searchButton);
    }

    private void addSearchListener() {
        titleInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final SearchState currentState = viewModel.getState();
                currentState.setTitle(titleInputField.getText());
                viewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final SearchState state = (SearchState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, state.getSearchError());
        }
        else if (evt.getPropertyName().equals("error")) {
            final SearchState state = (SearchState) evt.getNewValue();
            titleInputField.setText(state.getTitle());
            JOptionPane.showMessageDialog(this, state.getSearchError());
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }
}
