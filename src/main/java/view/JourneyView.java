package view;

import interface_adapter.journey.JourneyController;
import interface_adapter.add.AddController;
import interface_adapter.journey.JourneyState;
import interface_adapter.journey.JourneyViewModel;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JourneyView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName;
    private final JourneyViewModel viewModel;
    private JourneyController controller;

    private final JEditorPane articleContent;

    private final JCheckBox addNewPages;
    private final JButton addPage;

    private AddController addController;

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
        articleContent.setBackground(SwingStyle.background);
        articleContent.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));


        articleContent.addHyperlinkListener(
            new HyperlinkListener() {
                public void hyperlinkUpdate(HyperlinkEvent e) {
                    if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                        controller.execute(e.getDescription());
                        doAddPage();
                    }
                }
            }
        );

        JScrollPane scrollPane = new JScrollPane(articleContent);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        gbc.gridwidth = 3;
        gbc.ipady = 100;
        gbc.gridy = 0;
        gbc.gridx = 0;
        this.add(scrollPane, gbc);

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

        addNewPages.setOpaque(true);
        addNewPages.setBackground(SwingStyle.backgroundLight);
        addNewPages.setForeground(SwingStyle.text);
        addNewPages.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
        addNewPages.setFont(SwingStyle.fontBold);
        addNewPages.setMinimumSize(new Dimension(100, 30));


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(addNewPages, gbc);

        this.addPage = SwingStyle.makeAccentButton(JourneyViewModel.ADDPAGE_BUTTON_LABEL);
        addPage.setMinimumSize(new Dimension(100, 30));
        addPage.setMaximumSize(addPage.getMinimumSize());

        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 1;

        addPage.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(addPage)) {
                        doAddPage();
                    }
                }
            });
        this.add(addPage, gbc);
    }

    public void doAddPage() {
        final JourneyState state = viewModel.getState();
        String title = state.getCurrentPageTitle();
        addController.execute(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            articleContent.setText(viewModel.getState().getCurrentPageContent());
        } else if (evt.getPropertyName().equals("Bad Wiki Request Exception")) {
            JOptionPane.showMessageDialog(this,"Bad Wiki Request Exception");
        } else if (evt.getPropertyName().equals("Not a Wikipedia article link")) {
            JOptionPane.showMessageDialog(this,"Not a Wikipedia article link");
        } else if (evt.getPropertyName().equals("No matching result!")) {
            JOptionPane.showMessageDialog(this,"No matching result!");
        } else if (evt.getPropertyName().equals("Add Success")) {
            JOptionPane.showMessageDialog(this,"Current page added as node to graph");
        } else if (evt.getPropertyName().equals("Add Failure")) {
            JOptionPane.showMessageDialog(this,"Current journey node and current page mismatch");
        }
    }

    public void setController(JourneyController controller) {
        this.controller = controller;
    }

    public String getViewName() {
        return viewName;
    }

    public void setAddController(AddController addController) {
        this.addController = addController;
    }
}
