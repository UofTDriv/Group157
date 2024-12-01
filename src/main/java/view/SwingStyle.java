package view;

import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import java.awt.*;

public class SwingStyle {
    // fonts
    public static final Font font = new Font("PT Sans", Font.PLAIN, 16);
    public static final Font fontMed = new Font("PT Sans", Font.PLAIN, 24);
    public static final Font fontBold = new Font("PT Sans", Font.BOLD, 16);
    public static final Font fontBoldMed = new Font("PT Sans", Font.BOLD, 24);
    public static final Font heading = new Font("PT Sans", Font.BOLD, 36);

    // colors
    public static final Color background = Color.decode("#0a1127");
    public static final Color backgroundLight = Color.decode("#141c36");
    public static final Color backgroundLighter = Color.decode("#1c2541");
    public static final Color midtone = Color.decode("#3a506b");
    public static final Color accent = Color.decode("#52dad8");
    public static final Color minorText = Color.decode("#adbeab");
    public static final Color text = Color.decode("#ebeefa");

    public static JButton makeTab(String text) {
        JButton button = new JButton(text);
        button.setBackground(SwingStyle.backgroundLight);
        button.setForeground(SwingStyle.text);
        button.setFont(SwingStyle.fontBold);
        button.setBorder(BorderFactory.createDashedBorder(SwingStyle.midtone));
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(70, 40));
        return button;
    }

    public static JButton makeAccentButton(String text) {
        JButton button = new JButton(text);
        button.setFont(SwingStyle.fontBold);
        button.setBackground(SwingStyle.accent);
        button.setForeground(SwingStyle.background);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setSize(new Dimension(200, 50));
        button.setPreferredSize(button.getSize());
        button.setMaximumSize(button.getSize());
        return button;
    }

    public static JButton makeButton(String text) {
        JButton button = new JButton(text);
        button.setFont(SwingStyle.fontBold);
        button.setBackground(SwingStyle.backgroundLighter);
        button.setForeground(SwingStyle.text);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setSize(new Dimension(200, 50));
        button.setPreferredSize(button.getSize());
        button.setMaximumSize(button.getSize());
        return button;
    }

    public static JTextField makeTextField(String text, int cols) {
        JTextField textField = new JTextField(text, cols);
        textField.setMaximumSize(textField.getPreferredSize());
        textField.setFont(SwingStyle.fontMed);
        textField.setForeground(SwingStyle.text);
        textField.setCaretColor(SwingStyle.text);
        textField.setBackground(SwingStyle.backgroundLight);
        // this isnt working like i want it to but its not worse than it was before so maybe it'll fix itself
        // it did lol
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 3, 0, SwingStyle.accent),
                BorderFactory.createEmptyBorder(15,15,15,15)));
        return textField;
    }

    public static JTextField makeTextField(int cols) {
        return makeTextField("", cols);
    }

    public static JLabel makeLabel(String text) {
        JLabel label = new JLabel(text);
        label.setOpaque(false);
        label.setBorder(BorderFactory.createEmptyBorder());
        label.setFont(SwingStyle.fontBoldMed);
        label.setForeground(SwingStyle.text);

        return label;
    }

    public static JLabel makeHeading(String text) {
        JLabel heading = new JLabel(text);
        heading.setFont(SwingStyle.heading);
        heading.setForeground(SwingStyle.text);
        return heading;
    }
}
