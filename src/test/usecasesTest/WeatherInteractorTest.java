package test.usecasesTest;

import main.entities.Weather;
import main.frameworkdrivers.Gateways.WeatherDataProvider;
import main.usecases.WeatherInteractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherInteractorTest {

    private static class MockWeatherDataProvider implements WeatherDataProvider {
        @Override
        public double getTemperature() {
            return 25.0; // Pleasant temperature
        }
    }

    @Test
    public void testGetWeather() {
        WeatherDataProvider mockDataProvider = new MockWeatherDataProvider();
        WeatherInteractor weatherInteractor = new WeatherInteractor(mockDataProvider);

        Weather weather = weatherInteractor.getWeather();

        assertEquals(25.0, weather.getTemperature(), 0.001);
    }
}
