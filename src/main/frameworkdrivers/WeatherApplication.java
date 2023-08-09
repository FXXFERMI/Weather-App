package main.frameworkdrivers;

import main.frameworkdrivers.Gateways.ReminderProvider;
        import main.presentation.*;
        import main.usecases.WeatherUseCase;

        import javax.swing.*;
/**
 * WeatherApplication class is responsible for running the weather application. It initializes the
 * necessary components and manages the user interface to display weather information and reminders.
 */
public class WeatherApplication {
    /**
     * Run the weather application by initializing the UI components and setting up event handlers.
     *
     * @param userName        The username of the current user.
     * @param weatherUseCase  An instance of WeatherUseCase for managing weather-related functionality.
     * @param reminderProvider An instance of ReminderProvider for managing reminders.
     */

    public static void run(String userName, WeatherUseCase weatherUseCase, ReminderProvider reminderProvider) {
        SwingUtilities.invokeLater(() -> {
            // Create a WeatherApp instance
            WeatherApp weatherApp = new WeatherApp(weatherUseCase, reminderProvider, userName);

            // Initialize the ScheduleManager and load saved schedule
            ScheduleManager scheduleManager = new ScheduleManager();
            scheduleManager.loadSchedule(); // Load saved schedule

            // Create a ToDoListDialog and associate it with WeatherApp
            ToDoListDialog toDoListDialog = new ToDoListDialog(weatherApp);
            weatherApp.setToDoListDialog(toDoListDialog);
        });
    }
}


