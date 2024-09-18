package frame_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Canvas extends JPanel {

    private static Color color = Color.black;
    private static int brush_size;
    private int x, y;
    private ArrayList<ColorPoint> colorPath;

    //Storage of all points
    private ArrayList<ArrayList<ColorPoint>> allPaths;

    boolean mouseDragged = false;

    public Canvas(){

        //this.setBackground(Color.white);
        this.setBounds(200, 0, 600, 600);

        allPaths = new ArrayList<>(25);

        MouseAdapter mouseAdapter = new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                //Draw on mouse location
                drawOval(x, y, color, brush_size);

                //Start color path
                colorPath = new ArrayList<>(25);
                colorPath.add(new ColorPoint(x,y,color,brush_size));

            }
            public void mouseReleased(MouseEvent e){

                allPaths.add(colorPath);

                colorPath = null;
            }
            public void mouseDragged(MouseEvent e){

                x = e.getX();
                y = e.getY();

                ColorPoint nextPoint = new ColorPoint(e.getX(), e.getY(), color, brush_size);
                colorPath.add(nextPoint);

                //Draw on mouse location
                drawOval(x, y, color, brush_size);
            }
            /*public void mouseMoved(MouseEvent e){
                x = e.getX();
                y = e.getY();

                drawOval(x, y, color, brush_size);

            }*/

        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);

    }

    public static void setColor(Color c){
        color = c;
    }

    public static void setSize(int s){
        brush_size = s;
    }

    private void drawOval(int x_pos, int y_pos, Color p_color, int p_size){

        Graphics2D g2d = (Graphics2D) getGraphics();
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        g2d.setColor(p_color);
        g2d.fillOval(x_pos - (p_size/2),y_pos - (p_size/2),p_size,p_size);
        g2d.dispose();
    }
    private void drawOval(int x_pos, int y_pos, Color p_color, int p_size, Graphics2D g2d){

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        g2d.setColor(p_color);
        g2d.fillOval(x_pos - (p_size/2),y_pos - (p_size/2),p_size,p_size);

    }

    public void clearCanvas(){

        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
        g2d.dispose();

        allPaths = new ArrayList<>(25);
        colorPath = null;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //Redraw all paths created
        for(ArrayList<ColorPoint> path : allPaths){

            for(ColorPoint point : path){

                drawOval(point.getX(), point.getY(), point.getColor(), point.getSize(), g2d);
            }
        }
        g2d.dispose();
    }

}
