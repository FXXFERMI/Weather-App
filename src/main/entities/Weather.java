package main.entities;
/**
 * The Weather class represents weather information, including temperature and description.
 */
public class Weather {
    private double temperature;
    private String description;
    /**
     * Constructs a Weather object with the given temperature.
     *
     * @param temperature The temperature value in degrees Celsius.
     */

    public Weather(double temperature) {
        this.temperature = temperature;
    }
    /**
     * Gets the temperature value.
     *
     * @return The temperature in degrees Celsius.
     */

    public double getTemperature() {
        return temperature;
    }
}

