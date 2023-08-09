package main.usecases;

import main.entities.Weather;
/**
 * WeatherUseCase interface defines the contract for retrieving weather information.
 * Implementations of this interface will provide methods to fetch weather data.
 */
public interface WeatherUseCase {
    /**
     * Retrieves the current weather information.
     *
     * @return Weather object containing the current weather details.
     */

    Weather getWeather();
}

