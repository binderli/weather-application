package de.fh.albsig.exceptions;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;

import de.fh.albsig.binderlisa.weather.YahooParser;

public class WeatherException extends DocumentException {
	private static Logger log = Logger.getLogger(WeatherException.class);

	public WeatherException(Exception e) {
		log.error(e.getMessage(), e);
	}
}
