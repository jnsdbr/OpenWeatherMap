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

public interface OpenWeatherMapConstants
{
	String VERSION = "a0.1";
	String API_URL = "http://api.openweathermap.org/data/2.5/";
	String WEATHER = "weather?";
	String FORECAST = "forecast?";
	String TYPE_ACCURATE = "type=accurate";
	String TYPE_LIKE = "type=like";
	String APPID = "APPID=";
	String UNIT_METRIC = "units=metric";
	String UNIT_IMPERIAL = "units=imperial";
	String MODE_XML = "mode=xml";
}
