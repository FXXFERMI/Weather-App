package test.frameworkdriversTest;


import main.entities.Weather;
import main.frameworkdrivers.LoggingWeatherUseCaseDecorator;
import org.junit.jupiter.api.Test;
import main.usecases.WeatherUseCase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggingWeatherUseCaseDecoratorTest {

    private static class MockWeatherUseCase implements WeatherUseCase {
        @Override
        public Weather getWeather() {
            return new Weather(25.0);
        }
    }

    @Test
    public void testGetWeatherWithLogging() {
        WeatherUseCase mockUseCase = new MockWeatherUseCase();
        LoggingWeatherUseCaseDecorator decorator = new LoggingWeatherUseCaseDecorator(mockUseCase);

        Weather weather = decorator.getWeather();

        assertEquals(25.0, weather.getTemperature(), 0.001);
        // Additional assertions for log output can be added here
    }
}