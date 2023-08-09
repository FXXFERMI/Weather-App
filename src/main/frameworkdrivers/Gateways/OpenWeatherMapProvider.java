package main.frameworkdrivers.Gateways;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

/**
 * The `OpenWeatherMapProvider` class is an implementation of the `WeatherDataProvider` interface
 * that retrieves weather data from the OpenWeatherMap API. It fetches the current temperature
 * for a specified city using the API key and city name provided.
 */
public class OpenWeatherMapProvider implements WeatherDataProvider {

    // API Key for accessing the OpenWeatherMap API
    private final String API_KEY = "d3f2b19b3f4ade989d2b89e154117524";

    // City name for which weather data is to be fetche
    private final String CITY_NAME = "Mississauga";

    // Complete URL for making the API request
    private final String API_URL =
            "https://api.openweathermap.org/data/2.5/weather?q=" + CITY_NAME + "&appid=" + API_KEY;

    /**
     * Retrieves the current temperature in Celsius for the specified city from the OpenWeatherMap API.
     *
     * @return The current temperature in Celsius.
     * @throws IOException If an error occurs while making the API request.
     */
    @Override
    public double getTemperature() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject main = jsonResponse.getJSONObject("main");
            return main.getDouble("temp") - 273.15;  // Convert to Celsius
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;  // Default value if an error occurs
    }
}

