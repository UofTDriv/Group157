package view;

import javax.swing.*;
import java.awt.*;

/**
 * A panel containing a top title, interactable and button.
 */
public class StandardMenuPanel extends JPanel {
    private static final int TITLE_CONTENT_SPACING = 30;
    private static final int CENTER_BOTTOM_SPACING = 20;

    StandardMenuPanel(JLabel toptext, JComponent center, JComponent bottom) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        toptext.setAlignmentX(Component.CENTER_ALIGNMENT);

        center.setAlignmentX(Component.CENTER_ALIGNMENT);

        bottom.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(toptext);
        this.add(Box.createVerticalStrut(TITLE_CONTENT_SPACING));
        this.add(center);
        this.add(Box.createVerticalStrut(CENTER_BOTTOM_SPACING));
        this.add(bottom);
        this.add(Box.createVerticalGlue());
    }
}
