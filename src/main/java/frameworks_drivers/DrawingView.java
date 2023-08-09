package frameworks_drivers;

import interface_adapters.DrawingController;
import interface_adapters.IDrawingView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

/**
 * This class is the view for the drawing application
 * It is a JPanel that listens for mouse events and delegates them to the controller
 */
public class DrawingView extends JPanel implements IDrawingView {
    /**
     * The current color to draw with
     */
    private Color color = Color.BLACK;
    /**
     * The current image/drawing
     */
    private BufferedImage image;

    // X and y coordinates of the mouse's last known position
    // -1 if unknown or uninitialized
    private int x = -1;
    private int y = -1;

    public DrawingView(DrawingController drawingController) {

        setPreferredSize(new Dimension(500, 500));

        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                if (x != -1) {
                    drawingController.onDraw(x, y, e.getX(), e.getY(), color);
                }
                x = e.getX();
                y = e.getY();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                x = -1;
                y = -1;
            }
        });
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void updateCanvas(BufferedImage image) {
        this.image = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}