package main.usecases;

import main.entities.ReminderStrategy;
import main.frameworkdrivers.Gateways.ReminderProvider;

/**
 * ReminderGenerator class implements the ReminderProvider interface and serves as a use case
 * layer component responsible for generating reminders based on a provided strategy.
 */
public class ReminderGenerator implements ReminderProvider {
    private final ReminderStrategy strategy;
    /**
     * Constructor for the ReminderGenerator class. Initializes the generator with a specific reminder strategy.
     *
     * @param strategy ReminderStrategy to be used for generating reminders.
     */
    public ReminderGenerator(ReminderStrategy strategy) {
        this.strategy = strategy;
    }
    /**
     * Retrieves the reminder strategy associated with this generator.
     *
     * @param temperature The temperature value used to determine the reminder strategy.
     * @return ReminderStrategy associated with the generator.
     */
    @Override
    public ReminderStrategy getReminderStrategy(double temperature) {
        return strategy;
    }
    /**
     * Creates a new instance of ReminderGenerator with the provided reminder strategy.
     *
     * @param strategy ReminderStrategy to be used for generating reminders.
     * @return New ReminderGenerator instance.
     */
    public static ReminderGenerator withStrategy(ReminderStrategy strategy) {
        return new ReminderGenerator(strategy);
    }
}


