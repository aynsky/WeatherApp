package com.pathum.weather.model;

public class WeatherData {

    private String city;
    private String temperature;
    private int humidity;
    private double windSpeed;
    private double windDirection;
    private String description;

    // Constructor for the primary use case
    public WeatherData(String city, String temperature, int humidity, double windSpeed, double windDirection, String description) {
        this.city = (city != null) ? city : "Unknown";
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.description = description;
    }

    // Constructor for the alternative use case
    public WeatherData(String cityName, String temperature, String description, int humidity, double windDirection) {
        // Call the primary constructor with default values for windSpeed
        this(cityName, temperature, humidity, 0.0, windDirection, description);
    }

    public String getCity() {
        return city;
    }

    public String getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", description='" + description + '\'' +
                ", humidity=" + humidity +
                ", windDirection=" + windDirection +
                '}';
    }
}
