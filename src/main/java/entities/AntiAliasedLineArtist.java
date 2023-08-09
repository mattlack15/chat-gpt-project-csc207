package entities;

import java.awt.*;

public class AntiAliasedLineArtist implements DrawingStrategy {
    @Override
    public void draw(Graphics2D g2d, int x1, int y1, int x2, int y2, Color color) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the color for the line
        g2d.setColor(color);

        // Set the stroke (line thickness) for the line
        float strokeWidth = 3.5f; // Desired line thickness
        BasicStroke stroke = new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(stroke);

        // Draw the line using the specified coordinates
        g2d.drawLine(x1, y1, x2, y2);
    }
}
