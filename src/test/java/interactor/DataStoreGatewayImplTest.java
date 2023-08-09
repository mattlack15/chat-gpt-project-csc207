package interactor;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DataStoreGatewayImplTest {
    private DataStoreGatewayImpl dataStoreGateway;

    @BeforeEach
    void setUp() {
        dataStoreGateway = new DataStoreGatewayImpl();
    }

    @Test
    void testSaveDrawing() throws IOException {
        BufferedImage mockImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        File mockFile = new File("mockFile.png");

        // Call the method to be tested
        dataStoreGateway.saveDrawing(mockImage, mockFile);

        // Verify that the file exists and was created
        assertTrue(mockFile.exists(), "File should exist");
        assertTrue(mockFile.isFile(), "Should be a file");
    }

    @Test
    void testSaveDrawingIOException() {
        BufferedImage mockImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        File mockFile = new File("nonexistent/invalid/path/mockFile.png");

        // Call the method to be tested and expect an IOException
        assertThrows(IOException.class, () -> dataStoreGateway.saveDrawing(mockImage, mockFile));
    }

    @AfterAll
    static void tearDown() {
        File mockFile = new File("mockFile.png");
        mockFile.delete();
    }
}