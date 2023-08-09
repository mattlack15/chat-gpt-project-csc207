package frameworks_drivers;


import interactor.DataStoreGatewayImpl;
import interactor.DrawingInteractor;
import interface_adapters.DrawingController;
import interface_adapters.DrawingPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DrawingViewTest {
    private DrawingView drawingView;
    private DrawingController mockController;

    @BeforeEach
    void setUp() {
        mockController = new DrawingPresenter(
                new DrawingInteractor(
                        new DataStoreGatewayImpl()
                )
        );
        drawingView = new DrawingView(mockController);
    }

    @Test
    void testSetColor() {
        drawingView.setColor(Color.RED);
        assertEquals(Color.RED, drawingView.getColor(), "Color should be set to red");
    }

}
