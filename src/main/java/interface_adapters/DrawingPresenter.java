package interface_adapters;

import interactor.IDrawingUseCase;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Presenter for the drawing view, basically a delegator for the drawing use case
 */
public class DrawingPresenter implements DrawingController {
    private final IDrawingUseCase drawingUseCase;

    // To be initialized later with setView
    private IDrawingView view = null;

    public DrawingPresenter(IDrawingUseCase drawingUseCase) {
        this.drawingUseCase = drawingUseCase;
    }

    public void setView(IDrawingView view) {
        this.view = view;
    }

    @Override
    public void onDraw(int x, int y, int x2, int y2, Color color) {
        drawingUseCase.draw(x, y, x2, y2, color);
        view.updateCanvas(drawingUseCase.getDrawing());
    }

    @Override
    public void onSaveClicked(File file) throws IOException {
        drawingUseCase.saveToFile(file);
    }

    @Override
    public void onClearClicked() {
        drawingUseCase.clearCanvas();
        view.updateCanvas(drawingUseCase.getDrawing());
    }
}
