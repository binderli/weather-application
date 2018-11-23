package de.fh.albsig.exceptions;

import java.io.IOException;

import org.apache.log4j.Logger;

import de.fh.albsig.binderlisa.weather.YahooParser;

public class WeatherIOException  extends IOException{
	private static Logger log = Logger.getLogger(WeatherIOException.class);
	
	public WeatherIOException(Exception e) {
		log.error(e.getMessage(), e);
	}
	
}
