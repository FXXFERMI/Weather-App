package main.presentation;

import main.entities.Weather;
import main.frameworkdrivers.ScheduleManager;
import main.usecases.WeatherUseCase;

import main.frameworkdrivers.Gateways.ReminderProvider;
import main.entities.ReminderStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * WeatherApp is the main user interface class for the Weather Application.
 * It displays weather information, reminders, and a daily schedule for the user.
 */
public class WeatherApp extends JFrame {

    private JLabel weatherLabel;
    private JLabel reminderLabel;
    private JLabel timeLabel;
    private JLabel dateLabel;
    private JLabel nameLabel;
    private JButton createScheduleButton;
    public JTextArea scheduleTextArea;
    private ToDoListDialog toDoListDialog;
    private ScheduleManager scheduleManager;
    /**
     * Constructor for WeatherApp.
     *
     * @param weatherUseCase   WeatherUseCase instance to retrieve weather information.
     * @param reminderProvider ReminderProvider instance to generate reminders.
     * @param userName         The name of the user.
     */
    public WeatherApp(WeatherUseCase weatherUseCase, ReminderProvider reminderProvider, String userName) {
        setTitle("Weather App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        scheduleManager = new ScheduleManager();

        createScheduleButton = new JButton("Create Daily Schedule");
        createScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCreateScheduleDialog();
            }
        });
        add(createScheduleButton, BorderLayout.SOUTH);

        scheduleTextArea = new JTextArea();
        scheduleTextArea.setEditable(false);
        add(new JScrollPane(scheduleTextArea), BorderLayout.CENTER);

        nameLabel = new JLabel();
        weatherLabel = new JLabel();
        reminderLabel = new JLabel();
        timeLabel = new JLabel();
        dateLabel = new JLabel();

        nameLabel.setText("Welcome, " + userName + "!");

        Weather weather = weatherUseCase.getWeather();
        double temperature = weather.getTemperature();
        weatherLabel.setText("Weather: " + temperature + "°C");

        ReminderStrategy reminderStrategy = reminderProvider.getReminderStrategy(temperature);
        String reminder = reminderStrategy.generateReminder(temperature);
        reminderLabel.setText(reminder);

        updateTimeAndDate();

        add(nameLabel);
        add(weatherLabel);
        add(reminderLabel);
        add(timeLabel);
        add(dateLabel);

        setVisible(true);
    }
    /**
     * Displays the Create Schedule dialog.
     */
    public void showCreateScheduleDialog() {
        if (toDoListDialog == null) {
            toDoListDialog = new ToDoListDialog(this);
        }
        toDoListDialog.setVisible(true);
    }
    /**
     * Adds a schedule item to the daily schedule.
     *
     * @param item The item to be added to the schedule.
     */
    public void addScheduleItem(String item) {
        scheduleManager.getScheduleItems().add(item);
        scheduleManager.saveSchedule();
        updateScheduleTextArea();
    }
    /**
     * Updates the schedule text area with the current schedule items.
     */
    public void updateScheduleTextArea() {
        List<String> scheduleItems = scheduleManager.getScheduleItems();
        StringBuilder scheduleText = new StringBuilder("Daily Schedule:\n");
        for (String item : scheduleItems) {
            scheduleText.append("- ").append(item).append("\n");
        }
        scheduleTextArea.setText(scheduleText.toString());
    }

    private void updateTimeAndDate() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String currentTime = timeFormat.format(now);
        String currentDate = dateFormat.format(now);

        timeLabel.setText("Time: " + currentTime);
        dateLabel.setText("Date: " + currentDate);
    }
    /**
     * Sets the associated ToDoListDialog for this WeatherApp.
     *
     * @param dialog The ToDoListDialog instance to be associated.
     */
    public void setToDoListDialog(ToDoListDialog dialog) {
        toDoListDialog = dialog;
    }
}
