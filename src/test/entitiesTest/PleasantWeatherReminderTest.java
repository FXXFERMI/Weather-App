package test.entitiesTest;


import main.entities.PleasantWeatherReminder;
import main.entities.ReminderStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PleasantWeatherReminderTest {

    @Test
    public void testGenerateReminder() {
        ReminderStrategy reminderStrategy = new PleasantWeatherReminder();
        String reminder = reminderStrategy.generateReminder(25.0); // Pleasant temperature

        assertEquals("It's a pleasant day! You can go for a walk in the park.", reminder);
    }
}
