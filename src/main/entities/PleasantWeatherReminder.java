package main.entities;
/**
 * PleasantWeatherReminder class implements the ReminderStrategy interface to generate reminders based on
 * pleasant weather conditions. It provides a method to generate a reminder message for a given temperature.
 */
public class PleasantWeatherReminder implements ReminderStrategy {
    /**
     * Generates a reminder message based on the provided temperature.
     *
     * @param temperature The temperature value for which the reminder is being generated.
     * @return A reminder message suggesting a pleasant activity based on the temperature.
     */
    @Override
    public String generateReminder(double temperature) {
        return "It's a pleasant day! You can go for a walk in the park.";
    }
}