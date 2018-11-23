
package de.fh.albsig.binderlisa.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.dom4j.DocumentException;

/**
 * @author Lisa Binder Matrikel-Nummer: 86099
 *
 */
public class WeatherService {

    /**
     * Basis Konstruktor.
     */
    public WeatherService() {
    }

    /**
     * @param city        Stadt
     * @param countryCode Laenderkuerzel
     * @return gibt String zurueck
     * @throws URISyntaxException Exception
     * @throws IOException        Exception
     * @throws DocumentException  Exception
     */
    public String retrieveForecast(String city, String countryCode)
            throws URISyntaxException, IOException, DocumentException {
        // Retrieve Datan
        InputStream dataIn = new YahooRetriever().retrieve(city, countryCode);
        // Parse Data
        Weather weather = new YahooParser().parse(dataIn);
        // Format (Print) Data
        return new WeatherFormatter().format(weather);
    }

}
