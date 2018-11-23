
package de.fh.albsig.binderlisa;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.dom4j.DocumentException;

/**
 * @author Lisa Binder Matrikel-Nummer: 86099
 *
 */
public class Main {
    private static Logger log = Logger.getLogger(WeatherFormatter.class);

    /**
     * @param args Argumente aus der Konsole
     */
    public static void main(final String[] args) {

        PropertyConfigurator.configure(
                Main.class.getClassLoader().getResource("log4j.properties"));
        String city = "nome";
        String countryCode = "ak";
        try {
            city = args[0];
            countryCode = args[1];
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        try {
            new Main(city, countryCode).start();
        } catch (IOException | DocumentException | URISyntaxException e) {

            log.error(e.getMessage());
        }
    }

    /**
     * @param ci Variable fuer Stadt
     */
    private final String ci;

    /**
     * @param co Variable fuer Laenderkuerzel
     */
    private final String co;

    /**
     * @param city    Variable fuer Stadt
     * @param country Variable fuer Laenderkuerzel
     */
    public Main(final String city, final String country) {
        ci = city;
        co = country;
    }

    /**
     * @throws DocumentException  DocumentException
     * @throws URISyntaxException URISynteaxException
     * @throws IOException        IOException
     */
    public void start()
            throws DocumentException, URISyntaxException, IOException {
        final String path = "src/main/resources/";
        final XMLOutput xml = new XMLOutput();

        // Retrieve Data
        final InputStream dataIn = new YahooRetriever().retrieve(ci, co);

        // Parse Data
        final Weather weather = new YahooParser().parse(dataIn);

        // Write in XML Doc
        xml.writeToXML(weather, path);
        // Format (Print) Data
        System.out.print(new WeatherFormatter().format(weather));

    }

}
