package test.presentationTest;

import main.presentation.WeatherApp;
import main.usecases.WeatherUseCase;
import main.frameworkdrivers.Gateways.ReminderProvider;
import main.entities.ReminderStrategy;
import main.frameworkdrivers.ScheduleManager;
import main.entities.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherAppTest {

    private WeatherApp weatherApp;
    private MockWeatherUseCase mockWeatherUseCase;
    private MockReminderProvider mockReminderProvider;
    private MockScheduleManager mockScheduleManager;

    @BeforeEach
    public void setUp() {
        mockWeatherUseCase = new MockWeatherUseCase();
        mockReminderProvider = new MockReminderProvider();
        mockScheduleManager = new MockScheduleManager();
        weatherApp = new WeatherApp(mockWeatherUseCase, mockReminderProvider, "John");
    }

    @Test
    public void testUpdateScheduleTextArea() {
        SwingUtilities.invokeLater(() -> {
            java.util.List<String> testSchedule = List.of("Item 1", "Item 2", "Item 3");
            mockScheduleManager.setScheduleItems(testSchedule);

            weatherApp.updateScheduleTextArea();

            String expectedTextAreaContent = "Daily Schedule:\n- Item 1\n- Item 2\n- Item 3\n";
            assertEquals(expectedTextAreaContent, weatherApp.scheduleTextArea.getText());
        });
    }

    // Mock WeatherUseCase for testing purposes
    private class MockWeatherUseCase implements WeatherUseCase {
        @Override
        public Weather getWeather() {
            return new Weather(25.0); // Placeholder temperature
        }
    }

    // Mock ReminderProvider for testing purposes
    private class MockReminderProvider implements ReminderProvider {
        @Override
        public ReminderStrategy getReminderStrategy(double temperature) {
            return new ReminderStrategy() {
                @Override
                public String generateReminder(double temperature) {
                    return "Mock Reminder"; // Placeholder reminder
                }
            };
        }
    }

    // Mock ScheduleManager class for testing purposes
    private class MockScheduleManager extends ScheduleManager {
        private java.util.List<String> scheduleItems;

        public void setScheduleItems(java.util.List<String> scheduleItems) {
            this.scheduleItems = scheduleItems;
        }

        @Override
        public java.util.List<String> getScheduleItems() {
            return scheduleItems;
        }

        @Override
        public void saveSchedule() {
            // Do nothing in the mock
        }
    }
}

