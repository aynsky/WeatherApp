# WeatherApp

WeatherApp is a simple Java application that fetches weather information using the OpenWeatherMap API.

## Project Structure

WeatherApp/
|-- src/
| |-- com/
| |-- pathum/
| |-- weather/
| | |-- api/
| | | |-- WeatherApi.java
| | | |-- WeatherApiConfig.java
| | |-- model/
| | | |-- WeatherData.java
| | |-- UI/
| | |-- WeatherUI.java
| |-- weatherapp/
| |-- Weatherapp.java
|-- lib/
|-- (any JAR files you may be using)
|-- Manifest.txt
|-- README.md

## How to Use

1. **Compile the Code:**
    ```bash
    javac -cp lib/*: src/com/pathum/weather/api/WeatherApi.java src/com/pathum/weather/model/WeatherData.java src/com/pathum/weather/UI/WeatherUI.java src/com/pathum/weatherapp/Weatherapp.java
    ```

2. **Create a Manifest File (`Manifest.txt`):**
   ```text
   Main-Class: com.pathum.weatherapp.Weatherapp
   Class-Path: lib/json.jar


1.**Create the JAR File:**

        jar cfm WeatherApp.jar Manifest.txt -C src . -C lib json.jar

2.**Run the JAR File:**

    java -jar WeatherApp.jar


**Dependencies**
------------
JSON library - Ensure json.jar is in the lib folder.

**Configuration**
-----------
Make sure to obtain an API key from OpenWeatherMap and update the WeatherApiConfig.java file with your API key.

**License**
-------
This project is licensed under the MIT License.


Feel free to customize this template based on the specific details of your project. Include information about how to configure the application, any dependencies, and any other relevant details for users and contributors.
