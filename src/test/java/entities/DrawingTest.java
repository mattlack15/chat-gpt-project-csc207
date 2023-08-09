package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class DrawingTest {
    private Drawing drawing;

    @BeforeEach
    void setUp() {
        drawing = new Drawing(500, 500);
    }

    @Test
    void testClear() {
        drawing.drawLine(0, 0, 100, 100, Color.BLACK);
        drawing.clear();
        BufferedImage image = drawing.getImage();
        Color pixelColor = new Color(image.getRGB(50, 50), true);
        assertEquals(Color.WHITE, pixelColor, "Pixel color should be white after clearing");
    }

    @Test
    void testDrawLine() {
        drawing.drawLine(0, 0, 100, 100, Color.BLACK);
        BufferedImage image = drawing.getImage();
        Color pixelColor = new Color(image.getRGB(50, 50), true);
        assertEquals(Color.BLACK, pixelColor, "Pixel color should be black after drawing");
    }

}