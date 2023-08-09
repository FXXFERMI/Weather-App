package test.entitiesTest;


import main.entities.Weather;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherTest {

    @Test
    public void testGetTemperature() {
        Weather weather = new Weather(20.0); // Temperature: 20.0°C

        assertEquals(20.0, weather.getTemperature(), 0.001);
    }
}
