package interactor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Implementation of the data storage gateway
 */
public class DataStoreGatewayImpl implements DataStoreGateway {
    @Override
    public void saveDrawing(BufferedImage image, File file) throws IOException {
        ImageIO.write(image, "PNG", file);
    }

}




