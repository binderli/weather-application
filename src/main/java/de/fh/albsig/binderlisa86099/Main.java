package de.fh.albsig.binderlisa86099;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main {

	public static void main(String[] args) {

		// Configure Log4J
		PropertyConfigurator
				.configure(Main.class.getClassLoader()
						.getResource("log4j.properties"));
		// Read the zip code from the command line
		// (if none supplied, use 60202)
		String city = "nome";
		String countryCode = "ak";
		try {
			city = args[0];
			countryCode = args[1];
		} catch (final Exception e) {

		}

		// Start the programm
		try {
			new Main(city, countryCode).start();
		} catch (final Exception e) {

			e.printStackTrace();
		}
	}

	private final String ci;
	private final String country;

	public Main(String city, String country) {
		ci = city;
		this.country = country;
	}

	public void start() throws Exception {
		String path = "src/main/resources/";
		XMLOutput xml = new XMLOutput();

		// Retrieve Data
		final InputStream dataIn = new YahooRetriever()
				.retrieve(ci, country);

		// Parse Data
		final Weather weather = new YahooParser()
				.parse(dataIn);

		// Write in XML Doc
		xml.writeToXML(weather, path);
		// Format (Print) Data
		System.out.print(
				new WeatherFormatter().format(weather));

	}

}
