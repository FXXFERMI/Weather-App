/**
 * The WeatherDataProvider interface defines a contract for retrieving temperature data from various sources.
 * Implementing classes are expected to provide a method to fetch the current temperature.
 */
package main.frameworkdrivers.Gateways;
/**
 * Retrieves the current temperature from the data source.
 *
 * @return The current temperature in degrees Celsius.
 */
public interface WeatherDataProvider {
    double getTemperature();
}


