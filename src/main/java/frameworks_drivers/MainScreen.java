package frameworks_drivers;

import frameworks_drivers.file_name.FileNameGenerator;
import frameworks_drivers.file_name.TimeBasedFileNameGenerator;
import interactor.DataStoreGateway;
import interactor.DataStoreGatewayImpl;
import interactor.DrawingInteractor;
import interactor.IDrawingUseCase;
import interface_adapters.DrawingController;
import interface_adapters.DrawingPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * This class represents the main window of the drawing application.
 */
public class MainScreen extends JFrame {
    private final DrawingView drawingView;

    /**
     * Constructor to create the main window.
     *
     * @param view       The drawing view component.
     * @param controller The drawing controller that handles user interactions.
     */
    public MainScreen(FileNameGenerator fileNameStrategy, DrawingView view, DrawingController controller) {
        this.drawingView = view;

        // Set window title, close operation, and resizable property
        setTitle("Drawing App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Create color picker button
        JButton colorPickerButton = new JButton("Pick Color");
        colorPickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the color chooser dialog
                Color newColor = JColorChooser.showDialog(MainScreen.this, "Choose Color", drawingView.getColor());
                if (newColor != null) {
                    drawingView.setColor(newColor);
                }
            }
        });

        // Create save button and clear button
        JButton saveButton = new JButton("Save to File");
        JButton clearButton = new JButton("Clear Screen");

        // Set action listeners for save and clear buttons
        saveButton.addActionListener(e -> {
            try {
                String name = fileNameStrategy.generateFileName();
                File file = new File(name);
                controller.onSaveClicked(file);
                JOptionPane.showMessageDialog(MainScreen.this, "Saved to file: " + name, "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(MainScreen.this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        clearButton.addActionListener(e -> controller.onClearClicked());

        // Create a panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(colorPickerButton); // Add color picker button
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);

        // Set layout for the main window and add components
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(drawingView);
        add(buttonPanel);

        // Pack components and center the window
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Create instances of necessary components
        DataStoreGateway dataStore = new DataStoreGatewayImpl();
        IDrawingUseCase interactor = new DrawingInteractor(dataStore);
        DrawingPresenter controller = new DrawingPresenter(interactor);
        DrawingView view = new DrawingView(controller); // Create the view
        controller.setView(view); // Set the view on the controller

        FileNameGenerator fileNameStrategy = new TimeBasedFileNameGenerator();

        // Start the application's GUI thread
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainScreen mainScreen = new MainScreen(fileNameStrategy, view, controller);
            mainScreen.setVisible(true); // Display the main window
        });
    }
}
