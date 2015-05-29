import de.jnsdbr.openweathermap.*;

final String API_KEY = "";
OpenWeatherMap owm;
PFont font;

void setup() {
    size(400, 400);
    smooth();
    background(0);

    owm = new OpenWeatherMap(this, API_KEY, 2950159);
    //owm = new OpenWeatherMap(this, API_KEY, 52.52, 13.41);
    //owm = new OpenWeatherMap(this, API_KEY, "Berlin,de");

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

    font = createFont("Arial", 14);
    textFont(font);
    text("City: " + owm.getCity() + " (" + owm.getCountry() + ")", 3, 14);
    text("lat: " + owm.getLatitude() + " lon: " + owm.getLongitude(), 3, 30);
    text("Temp: " + owm.getTemperature() + " " + owm.getTemperatureUnit(), 3, 46);
    text("Description: " + owm.getWeatherDescription(), 3, 62);
    text("Last data update: " + owm.getLastUpdate(), 3, 94);
}