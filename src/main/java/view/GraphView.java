package view;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import interface_adapter.graph.GraphViewModel;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GraphView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName;
    private final GraphViewModel viewModel;

    private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);

    public GraphView(GraphViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewName = viewModel.getViewName();
        viewModel.addPropertyChangeListener(this);

        JGraphXAdapter<String, DefaultEdge> jgxAdapter = new JGraphXAdapter<>(viewModel.getState().getGraphT());

        this.setPreferredSize(DEFAULT_SIZE);

        final mxGraphComponent graphComponent = new mxGraphComponent(jgxAdapter);
        graphComponent.setEnabled(false);

        // positioning via jgraphx layouts
        mxCircleLayout layout = new mxCircleLayout(jgxAdapter);

        // center the circle
        int radius = 100;
        layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
        layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
        layout.setRadius(radius);
        layout.setMoveCircle(true);

        layout.execute(jgxAdapter.getDefaultParent());

        this.add(graphComponent);
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
