package test.entitiesTest;

import main.entities.ColdWeatherReminder;
import main.entities.ReminderStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColdWeatherReminderTest {

    @Test
    public void testGenerateReminder() {
        ReminderStrategy reminderStrategy = new ColdWeatherReminder();
        String reminder = reminderStrategy.generateReminder(10.0); // Cold temperature

        assertEquals("It's a bit cold outside. Don't forget to bundle up!", reminder);
    }
}

