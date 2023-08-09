package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawing {

    private final BufferedImage image;
    private final DrawingStrategy drawingStrategy;

    public Drawing(int width, int height, DrawingStrategy drawingStrategy) {
        this.drawingStrategy = drawingStrategy;
        // Create a new image of the specified width and height
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.WHITE); // Set the clear color (white in this case)
        g2d.fillRect(0, 0, image.getWidth(), image.getHeight()); // Fill the entire image with the clear color
    }

    public BufferedImage getImage() {
        return image;
    }

    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        // Create a Graphics2D object to draw on the image
        Graphics2D g2d = image.createGraphics();

        drawingStrategy.draw(g2d, x1, y1, x2, y2, color);

        // Dispose of the Graphics2D object to release resources
        g2d.dispose();
    }


    public void clear() {
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.WHITE); // Set the clear color (white in this case)
        g2d.fillRect(0, 0, image.getWidth(), image.getHeight()); // Fill the entire image with the clear color
        g2d.dispose();
    }

}
