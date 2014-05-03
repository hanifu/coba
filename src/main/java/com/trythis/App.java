package com.trythis;

/**
 * Hello world!
 *
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author sofyan.qusyairi
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.EllipseFigure;
import org.jhotdraw.draw.LineConnectionFigure;
import org.jhotdraw.draw.RectangleFigure;
import org.jhotdraw.draw.RoundRectangleFigure;
import org.jhotdraw.draw.TextFigure;
import org.jhotdraw.draw.TriangleFigure;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.draw.io.SerializationInputOutputFormat;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.util.ResourceBundleUtil;

//Error 

//reading included file Templates/Classes/../Licenses/license-jhotdraw.txt//
/**
 *
 * @author mirna nadia
 */

public class App 
{
    private App(){
        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

                // Create four drawing views, each one with its own drawing
                DrawingView view1 = new DefaultDrawingView();
                view1.setDrawing(createDrawing());

                // Create a common drawing editor for the views
                DrawingEditor editor = new DefaultDrawingEditor();
                editor.add(view1);

                // Create a tool bar with selection tool and a
                // creation tool for rectangle figures.
                JToolBar tb = new JToolBar();
                ButtonFactory.addSelectionToolTo(tb, editor);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new RectangleFigure()),
                        "edit.createRectangle",
                        labels);
                
                //creation tool for round rectangle figures.
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new RoundRectangleFigure()),
                        "edit.createRoundRectangle",
                        labels);
                
                //creation tool for triangle figures.
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TriangleFigure()),
                        "edit.createTriangle",
                        labels);
                
                //creation tool for ellipse figures.
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new EllipseFigure()),
                        "edit.createEllipse",
                        labels);
                
                //creation tool for text figures.
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TextFigure()),
                        "edit.createText",
                        labels);
                
                //creation tool for lineconnection figures.
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new LineConnectionFigure()),
                        "edit.createLineConnection",
                        labels);
                
                
                //tb.add(fontToolBar)
                tb.setOrientation(JToolBar.VERTICAL);

                // Put all together into a JFrame
                JFrame f = new JFrame("DrawSimply");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(400, 300);

                // Set up the content pane
                // Place the toolbar on the left
                // Place each drawing view into a scroll pane of its own
                // and put them into a larger scroll pane.
                JPanel innerPane = new JPanel();
                innerPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
                JScrollPane sp = new JScrollPane(view1.getComponent());
                innerPane.add(sp );
                sp.setPreferredSize(new Dimension(400, 300));
            
                f.getContentPane().add(new JScrollPane(innerPane));

                f.getContentPane().add(tb, BorderLayout.WEST);

                f.setVisible(true);
            }
        });
    }

    /**
     * Creates a drawing with input and output formats, so that drawing figures
     * can be copied and pasted between drawing views.
     * 
     * @return a drawing
     */
    private static Drawing createDrawing() {
        // Create a default drawing with
        // input/output formats for basic clipboard support.
        DefaultDrawing drawing = new DefaultDrawing();
        drawing.addInputFormat(new SerializationInputOutputFormat());
        drawing.addOutputFormat(new SerializationInputOutputFormat());
        return drawing;
    }
    
 }
