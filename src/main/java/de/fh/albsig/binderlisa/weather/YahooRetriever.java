package de.fh.albsig.binderlisa.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

/**
 * @author Lisa Binder Matrikel-Nummer: 86099
 *
 */

public class YahooRetriever {

    private static Logger log = Logger.getLogger(YahooRetriever.class);

    /**
     * @param city    Stadt, nach der Gesucht werden soll
     * @param country Laenderkuerzel, indem sich Stadt befindet
     * @return gibt InputStream zurueck
     * @throws URISyntaxException URISyntaxException
     * @throws IOException        IOException
     */
    public final InputStream retrieve(final String city, final String country)
            throws URISyntaxException, IOException {
        log.info("Retrieving Weather Data");
        final String url = "https://query.yahooapis.com/v1/public/yql?q="
                + "select%20*%20from%20weather.forecast%20where%20u%3D'c'"
                + "%20and%20woeid%20in%20(select%20woeid%20from%20geo.places"
                + "(1)%20where%20text%3D%22" + city + "%2C%20" + country
                + "%22)&format=xml&env=store%3A%2F%2Fdatatables."
                + "org%2Falltableswithkeys";
        final URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }
}
