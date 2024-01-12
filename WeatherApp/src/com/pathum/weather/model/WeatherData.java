package com.pathum.weather.model;

public class WeatherData {

    private String city;
    private double temperature;
    private int humidity;
    private double windSpeed;
    private double windDirection;
    private String description;

    
    // Constructor
    public WeatherData(String city, double temperature, int humidity, double windSpeed, int windDirection, String description){
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.description = description;
    }

    public WeatherData(String cityName, double temperature, String description, int humidity, double windDirection) {
        
    }

    public String getCity() {
        return city;
    }
    public double getTemperature() {
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

    // Setters (optional, depending on whether you need to modify these values)
    //public void setCity(String city){
        //this.city = city;
   // }
   // public void setTemperature(double temperature){
        //this.temperature = temperature;
   // }
    public void setHumidity(int humidity){
        this.humidity = humidity;
    }
   // public void setWindSpeed(double windSpeed){
        //this.windSpeed = windSpeed;
   // }
    public void setWindDirection(double windDirection){
        this.windDirection = windDirection;
    }
   // public void setDescription(String description){
        //this.description = description;   
   // }

}
