package view;

import javax.swing.*;
import java.awt.*;

/**
 * A panel containing a top title, interactable and button.
 */
public class StandardMenuPanel {
    public static final int TITLE_CONTENT_SPACING = 30;
    public static final int CENTER_BOTTOM_SPACING = 20;

    public static void standardUI(JPanel contentPane, JLabel toptext, JComponent center, JComponent bottom) {
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        toptext.setAlignmentX(Component.CENTER_ALIGNMENT);

        center.setAlignmentX(Component.CENTER_ALIGNMENT);

        bottom.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPane.add(Box.createVerticalGlue());
        contentPane.add(toptext);
        contentPane.add(Box.createVerticalStrut(TITLE_CONTENT_SPACING));
        contentPane.add(center);
        contentPane.add(Box.createVerticalStrut(CENTER_BOTTOM_SPACING));
        contentPane.add(bottom);
        contentPane.add(Box.createVerticalGlue());

        // yay pretty!
        contentPane.setBackground(SwingStyle.background);
    }
}
