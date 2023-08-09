package entities;

import java.awt.*;

public interface DrawingStrategy {
    void draw(Graphics2D graphics2D, int x, int y, int x2, int y2, Color color);
}
