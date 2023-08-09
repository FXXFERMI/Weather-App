package main.frameworkdrivers;

import main.entities.Weather;
import main.usecases.WeatherUseCase;
/**
 * LoggingWeatherUseCaseDecorator is a decorator class that adds logging functionality to a
 * WeatherUseCase implementation. It intercepts the getWeather() method call, logs the fetched
 * weather data, and then returns the weather data.
 */
public class LoggingWeatherUseCaseDecorator implements WeatherUseCase {
    private final WeatherUseCase wrappedUseCase;
    /**
     * Constructor for the LoggingWeatherUseCaseDecorator class.
     *
     * @param wrappedUseCase The underlying WeatherUseCase implementation to be decorated.
     */
    public LoggingWeatherUseCaseDecorator(WeatherUseCase wrappedUseCase) {
        this.wrappedUseCase = wrappedUseCase;
    }
    /**
     * Retrieves weather data while adding logging functionality. The method fetches the weather
     * data from the wrapped WeatherUseCase implementation, logs the temperature, and returns the
     * weather data.
     *
     * @return The weather data containing temperature and other information.
     */
    @Override
    public Weather getWeather() {
        Weather weather = wrappedUseCase.getWeather();
        System.out.println("Fetched weather data: " + weather.getTemperature() + "°C");
        return weather;
    }
}