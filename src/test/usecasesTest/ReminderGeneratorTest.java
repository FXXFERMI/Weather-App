package test.usecasesTest;


import main.entities.ReminderStrategy;
import main.usecases.ReminderGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReminderGeneratorTest {

    private static class MockReminderStrategy implements ReminderStrategy {
        @Override
        public String generateReminder(double temperature) {
            return "Mock Reminder";
        }
    }

    @Test
    public void testGetReminderStrategy() {
        ReminderStrategy mockStrategy = new MockReminderStrategy();
        ReminderGenerator reminderGenerator = ReminderGenerator.withStrategy(mockStrategy);

        ReminderStrategy strategy = reminderGenerator.getReminderStrategy(25.0);

        assertEquals("Mock Reminder", strategy.generateReminder(25.0));
    }
}
