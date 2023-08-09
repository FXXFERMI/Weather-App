package main.usecases;

import main.entities.ColdWeatherReminder;
import main.entities.PleasantWeatherReminder;
import main.entities.ReminderStrategy;
import main.frameworkdrivers.Gateways.ReminderProvider;
/**
 * ReminderStrategyFactory class implements the ReminderProvider interface to provide
 * different reminder strategies based on the temperature conditions. This factory
 * determines whether to provide a ColdWeatherReminder or a PleasantWeatherReminder
 * based on the input temperature.
 */
public class ReminderStrategyFactory implements ReminderProvider {
    /**
     * Get the appropriate reminder strategy based on the temperature.
     *
     * @param temperature The temperature for which the reminder strategy is required.
     * @return A ReminderStrategy instance representing the appropriate reminder strategy.
     */
    @Override
    public ReminderStrategy getReminderStrategy(double temperature) {
        if (temperature < 10) {
            return new ColdWeatherReminder();
        } else {
            return new PleasantWeatherReminder();
        }
    }
}