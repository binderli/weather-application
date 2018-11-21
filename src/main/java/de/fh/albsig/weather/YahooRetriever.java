package de.fh.albsig.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class YahooRetriever {
	private static Logger log = Logger
			.getLogger(YahooRetriever.class);

	public InputStream retrieve(String city, String country)
			throws Exception {
		log.info("Retrieving Weather Data");
		final String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20u%3D'c'%20and%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22"
				+ city + "%2C%20" + country
				+ "%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
		final URLConnection conn = new URL(url)
				.openConnection();
		return conn.getInputStream();
	}
}
