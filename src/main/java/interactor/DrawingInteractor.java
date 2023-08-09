package interactor;

import entities.AntiAliasedLineArtist;
import entities.Drawing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawingInteractor implements IDrawingUseCase {
    private final Drawing drawing = new Drawing(500, 500, new AntiAliasedLineArtist());
    private final DataStoreGateway gateway;

    public DrawingInteractor(DataStoreGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void draw(int x, int y, int x2, int y2, Color color) {
        drawing.drawLine(x, y, x2, y2, color);
    }

    @Override
    public void saveToFile(File file) throws IOException {
        gateway.saveDrawing(drawing.getImage(), file);
    }

    @Override
    public BufferedImage getDrawing() {
        return drawing.getImage();
    }

    @Override
    public void clearCanvas() {
        drawing.clear();
    }
}
