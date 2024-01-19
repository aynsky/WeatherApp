package com.pathum.weather.UI;

import com.pathum.weather.api.WeatherApi;
import com.pathum.weather.model.WeatherData;
import java.util.Scanner;

public class WeatherUI {


    public static void run(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter city name : ");
        String city = sc.nextLine();
        
        
        WeatherData weatherData = WeatherApi.getWeatherData(city);

        if(weatherData != null){
            displayWeatherInfo(weatherData);

        }else{
            System.out.println("Unable to fetch weather info");
        }

        sc.close();
    }

    public static void displayWeatherInfo(WeatherData weatherData){
        System.out.println();
        System.out.println("Weather information for " + weatherData.getCity());
        System.out.println();
        System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
        System.out.println();
        System.out.println("Description: " + weatherData.getDescription());
        System.out.println();
        System.out.println("Humidity: " + weatherData.getHumidity() + "%");
        System.out.println();
        System.out.println("Wind Speed: " + weatherData.getWindDirection() + " m/s");
        System.out.println();
    }

    public static void displayTitle() {
        System.out.println("*******************************************");
        System.out.println("*          Welcome to WeatherApp           *");
        System.out.println("*******************************************");
        System.out.println();
    }
}