package test.frameworkdriversTest;

import main.entities.ReminderStrategy;
import main.entities.Weather;
import main.frameworkdrivers.WeatherApplication;
import main.usecases.WeatherUseCase;
import main.frameworkdrivers.Gateways.ReminderProvider;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class WeatherApplicationTest {

    @Test
    public void testWeatherApplicationRun() {
        SwingUtilities.invokeLater(() -> {
            // Mock WeatherUseCase and ReminderProvider for testing
            WeatherUseCase mockWeatherUseCase = new MockWeatherUseCase();
            ReminderProvider mockReminderProvider = new MockReminderProvider();

            WeatherApplication.run("Test User", mockWeatherUseCase, mockReminderProvider);

            // Give the application time to initialize
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Find the WeatherApp window and close it
            Frame[] frames = Frame.getFrames();
            for (Frame frame : frames) {
                if (frame instanceof JFrame) {
                    JFrame jFrame = (JFrame) frame;
                    if (jFrame.getTitle().equals("Weather App")) {
                        jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
                    }
                }
            }
        });
    }

    // Mock WeatherUseCase for testing purposes
    private static class MockWeatherUseCase implements WeatherUseCase {
        @Override
        public Weather getWeather() {
            return new Weather(25.0); // Placeholder temperature
        }
    }

    // Mock ReminderProvider for testing purposes
    private static class MockReminderProvider implements ReminderProvider {
        @Override
        public ReminderStrategy getReminderStrategy(double temperature) {
            return null; // Placeholder
        }
    }
}




