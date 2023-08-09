package main.entities;

/**
 * ReminderStrategy Interface
 *
 * This interface defines a strategy for generating reminders based on a given temperature value.
 * Classes implementing this interface should provide a method to generate a reminder message
 * based on the temperature parameter.
 */
public interface ReminderStrategy {
    /**
     * Generates a reminder message based on the given temperature.
     *
     * @param temperature The temperature value for which the reminder is to be generated.
     * @return A reminder message based on the temperature value.
     */
    String generateReminder(double temperature);
}




