package main.frameworkdrivers.Gateways;
import main.entities.ReminderStrategy;
/**
 * ReminderProvider interface defines the contract for obtaining a reminder strategy based on temperature.
 * Implementing classes should provide a mechanism to determine the appropriate reminder strategy
 * based on the given temperature.
 */
public interface ReminderProvider {
    /**
     * Retrieves the appropriate reminder strategy based on the provided temperature.
     *
     * @param temperature The temperature value used to determine the reminder strategy.
     * @return A ReminderStrategy representing the appropriate reminder strategy.
     */
    ReminderStrategy getReminderStrategy(double temperature);
}
