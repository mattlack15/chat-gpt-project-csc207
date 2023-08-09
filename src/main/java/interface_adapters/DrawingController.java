package interface_adapters;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Delegator to use case
 */
public interface DrawingController {
    /**
     * Should be called when the user draws on the canvas
     * @param x The x coordinate of the first point
     * @param y The y coordinate of the first point
     * @param x2 The x coordinate of the second point
     * @param y2 The y coordinate of the second point
     * @param color The color of the line
     */
    void onDraw(int x, int y, int x2, int y2, Color color);

    /**
     * Should be called when the user clicks the save button
     * @param file The file to save to
     * @throws IOException If an I/O error occurs
     */
    void onSaveClicked(File file) throws IOException;

    /**
     * Should be called when the user clicks the clear button
     */
    void onClearClicked();
}