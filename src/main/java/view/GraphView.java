package view;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import interface_adapter.graph.GraphController;
import interface_adapter.graph.GraphViewModel;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GraphView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName;
    private final GraphViewModel viewModel;
    private GraphController controller;

    private final JGraphXAdapter<String, DefaultEdge> jgxAdapter;
    private mxGraphLayout layout;
    private final mxCircleLayout circleLayout;

    final JButton compactTreeLayoutButton;

    private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);

    public GraphView(GraphViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);
        this.setLayout(new BorderLayout());

        this.jgxAdapter = new JGraphXAdapter<>(viewModel.getState().getGraphT());

        this.setPreferredSize(DEFAULT_SIZE);

        final mxGraphComponent graphComponent = new mxGraphComponent(jgxAdapter);
        graphComponent.setEnabled(false);

        // positioning via jgraphx layouts
        this.circleLayout = new mxCircleLayout(jgxAdapter);
        int radius = 150;
        circleLayout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
        circleLayout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
        circleLayout.setRadius(radius);
        circleLayout.setMoveCircle(true);

        this.layout = circleLayout;

        layout.execute(jgxAdapter.getDefaultParent());

        graphComponent.getGraphControl().addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e)
            {
                Object cell = graphComponent.getCellAt(e.getX(), e.getY());
                if (cell != null)
                {
                    mxCell check = (mxCell) cell;
                    if (check.isVertex()) {
                        controller.execute(jgxAdapter.getLabel(cell));
                    }
                }
            }
        });
        this.add(graphComponent, BorderLayout.CENTER);

        this.compactTreeLayoutButton = SwingStyle.makeButton("Use Compact Tree Layout");

        compactTreeLayoutButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(compactTreeLayoutButton)) {
                            layout = new mxCompactTreeLayout(jgxAdapter, false);
                            layout.execute(jgxAdapter.getDefaultParent());
                        }
                    }
                }
        );

        this.add(compactTreeLayoutButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            layout.execute(jgxAdapter.getDefaultParent());
            jgxAdapter.getEdgeToCellMap().forEach((edge, cell) -> cell.setValue(null));
        }
    }

    public void setController(GraphController controller) {
        this.controller = controller;
    }

    public String getViewName() {
        return viewName;
    }
}
