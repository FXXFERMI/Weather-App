package main.presentation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The `ToDoListDialog` class represents a dialog box for creating a daily schedule to-do list.
 * It provides a text area for entering tasks and a save button to save the entered tasks
 * as schedule items in the parent WeatherApp.
 */
public class ToDoListDialog extends JDialog {

    private JTextArea toDoListTextArea;
    private JButton saveButton;

    private WeatherApp weatherApp;
    /**
     * Constructs a new `ToDoListDialog` instance associated with the provided WeatherApp.
     *
     * @param parent The parent WeatherApp instance that invokes this dialog.
     */
    public ToDoListDialog(WeatherApp parent) {
        super(parent, "Create Daily Schedule", true);
        this.weatherApp = parent;

        // Set up dialog layout
        setLayout(new BorderLayout());

        // Create a JTextArea for the to-do list
        toDoListTextArea = new JTextArea();
        add(new JScrollPane(toDoListTextArea), BorderLayout.CENTER);

        // Create a JButton to save the to-do list
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToDoList(); // Call the method to save the to-do list
                setVisible(false); // Hide the dialog
            }
        });
        add(saveButton, BorderLayout.SOUTH);

        setSize(300, 200); // Set the size of the dialog
        setLocationRelativeTo(parent); // Center the dialog relative to the parent (WeatherApp)
    }
    /**
     * Saves the entered to-do list items as schedule items in the parent WeatherApp.
     * Splits the text area content into individual lines and adds non-empty items to the schedule.
     */
    private void saveToDoList() {
        // Split the text area content into individual lines
        String[] items = toDoListTextArea.getText().split("\n");

        // Loop through the lines and add non-empty items to the schedule
        for (String item : items) {
            if (!item.trim().isEmpty()) {
                weatherApp.addScheduleItem(item); // Call the method in WeatherApp to add the item
            }
        }
    }
}

