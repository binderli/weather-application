package de.fh.albsig.binderlisa;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

/**
 * @author Lisa Binder Matrikel-Nummer: 86099
 *
 */

public class YahooParser {

    private static Logger log = Logger.getLogger(YahooParser.class);

    /**
     * @param inputStream Daten von Yahoo
     * @return gibt Wetter-Objekt zurueck
     * @throws DocumentException falls Exceptions auftreten
     */
    public final Weather parse(final InputStream inputStream)
            throws DocumentException {
        final Weather weather = new Weather();
        log.info("Creating XML Reader");

        final SAXReader xmlReader = createXMLReader();
        final Document doc = xmlReader.read(inputStream);

        log.info("Parsing XML Response");
        weather.setCity(
                doc.valueOf("/query/results/channel/yweather:location/@city"));
        weather.setRegion(doc
                .valueOf("/query/results/channel/yweather:location/@region"));
        weather.setCountry(doc
                .valueOf("/query/results/channel/yweather:location/@country"));
        weather.setCondition(doc.valueOf(
                "/query/results/channel/item/yweather:condition/@text"));
        weather.setTemp(doc.valueOf(
                "/query/results/channel/item/yweather:condition/@temp"));
        weather.setChill(
                doc.valueOf("/query/results/channel/yweather:wind/@chill"));
        weather.setHumidity(doc.valueOf(
                "/query/results/channel/yweather:atmosphere/@humidity"));

        return weather;
    }

    /**
     * @return gibt xmlReader zurueck
     */
    private SAXReader createXMLReader() {
        final Map<String, String> uris = new HashMap<>();
        uris.put("yweather", "http://xml.weather.yahoo.com/ns/rss/1.0");
        final DocumentFactory factory = new DocumentFactory();
        factory.setXPathNamespaceURIs(uris);
        final SAXReader xmlReader = new SAXReader();
        xmlReader.setDocumentFactory(factory);
        return xmlReader;
    }
}
