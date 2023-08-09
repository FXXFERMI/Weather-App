package main.usecases;

import main.entities.Weather;
import main.frameworkdrivers.Gateways.WeatherDataProvider;
/**
 * WeatherInteractor class is responsible for handling the Weather use case. It interacts with the
 * WeatherDataProvider to fetch weather information and provides the necessary data to the application.
 */
public class WeatherInteractor implements WeatherUseCase {
    private final WeatherDataProvider dataProvider;
    /**
     * Constructor for the WeatherInteractor class. Initializes the interactor with a WeatherDataProvider.
     *
     * @param dataProvider The WeatherDataProvider instance to retrieve weather data.
     */
    public WeatherInteractor(WeatherDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }
    /**
     * Retrieves the current weather information.
     *
     * @return Weather object containing the current weather data.
     */
    @Override
    public Weather getWeather() {
        double temperature = dataProvider.getTemperature();
        return new Weather(temperature);
    }
}
