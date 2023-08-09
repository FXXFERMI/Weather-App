package main;

import main.entities.ReminderStrategy;
import main.frameworkdrivers.Gateways.OpenWeatherMapProvider;
import main.frameworkdrivers.Gateways.ReminderProvider;
import main.frameworkdrivers.Gateways.WeatherDataProvider;
import main.frameworkdrivers.LoggingWeatherUseCaseDecorator;
import main.frameworkdrivers.WeatherApplication;
import main.usecases.WeatherInteractor;
import main.usecases.WeatherUseCase;
import main.usecases.ReminderStrategyFactory;

import javax.swing.*;
/**
 * Main class to initiate the Weather Application.
 */
public class Main {
    /**
     * The entry point of the Weather Application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String userName = "Solar Kim"; // Replace with user's name

        SwingUtilities.invokeLater(() -> {
            // Initialize WeatherDataProvider with OpenWeatherMapProvider
            WeatherDataProvider dataProvider = new OpenWeatherMapProvider();
            // Initialize WeatherUseCase with WeatherInteractor and LoggingWeatherUseCaseDecorator
            WeatherUseCase weatherUseCase = new WeatherInteractor(dataProvider);
            // Initialize ReminderProvider and get ReminderStrategy based on current weather temperature
            weatherUseCase = new LoggingWeatherUseCaseDecorator(weatherUseCase);

            ReminderProvider reminderProvider = new ReminderStrategyFactory();
            ReminderStrategy reminderStrategy = reminderProvider.getReminderStrategy(
                    weatherUseCase.getWeather().getTemperature());
            // Run WeatherApplication with initialized components
            WeatherApplication.run(userName, weatherUseCase, reminderProvider);
        });
    }
}






