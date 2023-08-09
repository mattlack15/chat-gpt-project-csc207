package interactor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Use case for drawing, includes methods for various operations
 */
public interface IDrawingUseCase {
    /**
     * Draw a line between two points
     * @param x The x coordinate of the first point
     * @param y The y coordinate of the first point
     * @param x2 The x coordinate of the second point
     * @param y2 The y coordinate of the second point
     * @param color The color of the line
     */
    void draw(int x, int y, int x2, int y2, Color color);

    /**
     * Save the drawing to a file
     * @param file The file to save to
     * @throws IOException If an I/O error occurs
     */
    void saveToFile(File file) throws IOException;

    /**
     * Get the current drawing
     * @return The current drawing
     */
    BufferedImage getDrawing();

    /**
     * Clear the canvas
     */
    void clearCanvas();
}
