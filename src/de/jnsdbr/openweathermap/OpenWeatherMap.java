/**
 * OpenWeatherMap
 * Retrieve weather data from OpenWeatherMap
 * http://owm.jnsdbr.de
 *
 * Copyright (c) 2015 Jens de Boer http://jnsdbr.de
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 *
 * @author      Jens de Boer http://jnsdbr.de
 * @modified    05/29/2015
 * @version     1.0.0 (1)
 */
package de.jnsdbr.openweathermap;

import processing.core.*;
import processing.data.XML;


public class OpenWeatherMap implements OpenWeatherMapConstants {
	private PApplet parent;
	private String url;
	private XML apiResponse;

	private int id;
	private String APPID;

	public OpenWeatherMap (PApplet parent, String key, double lat, double lon) {
		this.parent = parent;
		this.APPID = key;

		url = API_URL + WEATHER + "&APPID=" + this.APPID + "&lat=" + lat + "&lon=" + lon + "&" + TYPE_ACCURATE + "&" + UNIT_METRIC +"&" + MODE_XML;
		apiResponse = parent.loadXML(url);

		this.id = getCityId();
		welcome();
	}

	public OpenWeatherMap (PApplet parent, String key, String name) {
		this.parent = parent;
		this.APPID = key;

		url = API_URL + WEATHER + "&APPID=" + this.APPID + "&q=" + name + "&" + TYPE_ACCURATE + "&" + UNIT_METRIC +"&" + MODE_XML;
		apiResponse = parent.loadXML(url);

		this.id = getCityId();
		welcome();
	}

	public OpenWeatherMap (PApplet parent, String key, int id) {
		this.parent = parent;
		this.id = id;
		this.APPID = key;

		url = API_URL + WEATHER + "&APPID=" + this.APPID + "&id=" + this.id + "&" + TYPE_ACCURATE + "&" + UNIT_METRIC +"&" + MODE_XML;
		apiResponse = parent.loadXML(url);
		welcome();
	}

	private void welcome() {
		System.out.println("OpenWeatherMap library " + VERSION + " loaded");
	}

	public void refresh() {
		apiResponse = parent.loadXML(url);
	}

	public void changeUnits(boolean metric) {
		if(metric) {
			url = API_URL + WEATHER + "&APPID=" + this.APPID + "&id=" + this.id + "&" + TYPE_ACCURATE + "&" + UNIT_METRIC +"&" + MODE_XML;
		} else {
			url = API_URL + WEATHER + "&APPID=" + this.APPID + "&id=" + this.id + "&" + TYPE_ACCURATE + "&" + UNIT_IMPERIAL +"&" + MODE_XML;
		}
		refresh();
	}

	// Last Update
	public String getLastUpdate() {
		XML[] children = apiResponse.getChildren("lastupdate");
		return children[0].getString("value");
	}

	// Weather
	public String getWeatherDescription() {
		XML[] children = apiResponse.getChildren("weather");
		return children[0].getString("value");
	}

	// City
	public String getCity() {
		XML[] children = apiResponse.getChildren("city");
		return children[0].getString("name");
	}

	public int getCityId() {
		XML[] children = apiResponse.getChildren("city");
		return children[0].getInt("id");
	}

	// Coords
	public double getLatitude() {
		XML[] children = apiResponse.getChildren("city")[0].getChildren("coord");
		return children[0].getDouble("lat");
	}

	public double getLongitude() {
		XML[] children = apiResponse.getChildren("city")[0].getChildren("coord");
		return children[0].getDouble("lon");
	}

	// Sun
	public String getSunRise() {
		XML[] children = apiResponse.getChildren("city")[0].getChildren("sun");
		return children[0].getString("rise");
	}

	public String getSunSet() {
		XML[] children = apiResponse.getChildren("city")[0].getChildren("sun");
		return children[0].getString("set");
	}

	// Country
	public String getCountry() {
		XML[] children = apiResponse.getChildren("city")[0].getChildren("country");
		return children[0].getContent();
	}

	// Temperature
	public double getTemperature() {
		XML[] children = apiResponse.getChildren("temperature");
		return children[0].getDouble("value");
	}

	public String getTemperatureUnit() {
		XML[] children = apiResponse.getChildren("temperature");
		return children[0].getString("unit");
	}

	// Humidity
	public int getHumidity() {
		XML[] children = apiResponse.getChildren("humidity");
		return children[0].getInt("value");
	}

	// Pressure
	public double getPressure() {
		XML[] children = apiResponse.getChildren("pressure");
		return children[0].getDouble("value");
	}

	public String getPressureUnit() {
		XML[] children = apiResponse.getChildren("pressure");
		return children[0].getString("unit");
	}

	// Clouds
	public String getCloudsDescription() {
		XML[] children = apiResponse.getChildren("clouds");
		return children[0].getString("name");
	}

	public int getClouds() {
		XML[] children = apiResponse.getChildren("clouds");
		return children[0].getInt("value");
	}

	// Wind speed
	public double getWindSpeed() {
		XML[] children = apiResponse.getChildren("wind")[0].getChildren("speed");
		return children[0].getDouble("value");
	}

	public String getWindSpeedDescription() {
		XML[] children = apiResponse.getChildren("wind")[0].getChildren("speed");
		return children[0].getString("name");
	}

	// Wind direction
	public double getWindDirection() {
		XML[] children = apiResponse.getChildren("wind")[0].getChildren("direction");
		return children[0].getDouble("value");
	}

	public String getWindDirectionDescription() {
		XML[] children = apiResponse.getChildren("wind")[0].getChildren("direction");
		return children[0].getString("name");
	}

	public String getWindDirectionCode() {
		XML[] children = apiResponse.getChildren("wind")[0].getChildren("direction");
		return children[0].getString("code");
	}
}
