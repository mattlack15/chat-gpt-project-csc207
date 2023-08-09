package interactor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public interface DataStoreGateway {
    /**
     * Saves the drawing to a file
     * @param image The drawing to save
     * @param file The file to save to
     * @throws IOException If an I/O error occurs
     */
    void saveDrawing(BufferedImage image, File file) throws IOException;
}