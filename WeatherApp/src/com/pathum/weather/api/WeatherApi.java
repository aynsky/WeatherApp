// Example: WeatherApi.java
package com.pathum.weather.api;

import com.pathum.weather.model.WeatherData;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApi {
    private static final String API_KEY = WeatherApiConfig.API_KEY;
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";

    public static WeatherData getWeatherData(String city) {
        try {
            // Construct the API request URL
            URL url = new URL(API_URL + "?q=" + city + "&appid=" + API_KEY);

            // Open a connection to the API
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Check the HTTP response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the API response
                try (InputStream inputStream = connection.getInputStream();
                     Scanner scanner = new Scanner(inputStream)) {

                    StringBuilder response = new StringBuilder();
                    while (scanner.hasNext()) {
                        response.append(scanner.next());
                    }

                    // Parse the JSON response
                    JSONObject jsonResponse = new JSONObject(response.toString());

                    // Print the raw JSON response for debugging
                    //LSystem.out.println("Raw JSON Response: " + jsonResponse.toString());

                    // Extract relevant data
                    String cityName = jsonResponse.getString("name");
                    double temperatureKelvin = jsonResponse.getJSONObject("main").getDouble("temp");
                    String description = jsonResponse.getJSONArray("weather")
                            .getJSONObject(0).getString("description");
                    int humidity = jsonResponse.getJSONObject("main").getInt("humidity");
                    double windDirection = jsonResponse.getJSONObject("wind").getDouble("speed");

                    // Convert temperature from Kelvin to Celsius
                    double temperatureCelsius = temperatureKelvin - 273.15;

                    // Format temperature to have two decimal places
                    String formattedTemperature = String.format("%.2f", temperatureCelsius);



                    /*System.out.println("Extracted values - City: " + cityName + ", Temperature: " + temperature +
                                        ", Description: " + description + ", Humidity: " + humidity + ", Wind Direction: " + windDirection);*/

                    // Create a WeatherData object
                    WeatherData weatherData = new WeatherData(cityName, formattedTemperature, description, humidity, windDirection);
                    //System.out.println("WeatherData Object: " + weatherData);

                    

                    // Display the WeatherData object properties
                    /*System.out.println("City: " + weatherData.getCity() + ", Temperature: " + weatherData.getTemperature() +
                                        ", Description: " + weatherData.getDescription() + ", Humidity: " + weatherData.getHumidity() +
                                        ", Wind Direction: " + weatherData.getWindDirection());*/
                    return weatherData;


                } // InputStream and Scanner will be automatically closed here
            } else {
                System.out.println("HTTP error code: " + responseCode);
            }
        } catch (IOException e) {
            // Handle exceptions (e.g., connection error)
            e.printStackTrace();
        }
        return null; // Return null in case of exceptions or HTTP error
    }
}
