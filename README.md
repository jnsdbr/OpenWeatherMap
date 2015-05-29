# OpenWeatherMap
Processing weather library based on the OpenWeatherMap API


## Basic Usage
```Java
import de.jnsdbr.openweathermap.*;

OpenWeatherMap owm;
final String API_KEY = ""

void setup() {
  owm = new OpenWeatherMap(this, API_KEY, "Berlin,de");
  
  println("Temp: " + owm.getTemperature(), "Units: " + owm.getTemperatureUnit());
  println("Wind speed: " + owm.getWindSpeed(), "Wind speed description: " + owm.getWindSpeedDescription());
  println("Wind direction: " + owm.getWindDirection(), "Wind direction code: " + owm.getWindDirectionCode(), "Wind direction description: " + owm.getWindDirectionDescription());
  println("City: " + owm.getCity(), "id: " + owm.getCityId(), "Country: " + owm.getCountry());
  println("Lat: " + owm.getLatitude(), "Lon: " + owm.getLongitude());
  println("Sunrise at: " + owm.getSunRise(), "Sunset at: " + owm.getSunSet());
  println("Humidity: " + owm.getHumidity(), "Pressure: " + owm.getPressure(), "Pressure unit: " + owm.getPressureUnit());
  println("Weather description: " + owm.getWeatherDescription());
  println("Clouds description: " + owm.getCloudsDescription(), "Clouds value: " + owm.getClouds());
  println("Last data update: " + owm.getLastUpdate());
}
```
