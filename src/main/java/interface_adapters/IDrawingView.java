package interface_adapters;

import java.awt.image.BufferedImage;

/**
 * Output boundary for drawing
 */
public interface IDrawingView {
    /**
     * Updates the canvas with the given image
     * @param image The image to update the canvas with
     */
    void updateCanvas(BufferedImage image);
}