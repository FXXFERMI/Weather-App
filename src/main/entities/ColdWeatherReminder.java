package main.entities;
/**
 * ColdWeatherReminder class implements the ReminderStrategy interface to generate reminders
 * based on cold weather conditions.
 */
public class ColdWeatherReminder implements ReminderStrategy {
    /**
     * Generates a reminder message based on the temperature.
     *
     * @param temperature The current temperature in degrees Celsius.
     * @return A reminder message based on the temperature condition.
     */
    @Override
    public String generateReminder(double temperature) {
        return "It's a bit cold outside. Don't forget to bundle up!";
    }
}