package de.fh.albsig.binderlisa.weather;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author Lisa Binder Matrikel-Nummer: 86099
 *
 */

public class XMLOutput {

    private Document xml;

    /**
     * @param weather Wetter-Objekt
     * @param path    Pfad, in dem XML gespeichert werden soll
     * @throws IOException falls Exceptions auftreten
     */
    public final void writeToXML(final Weather weather, final String path)
            throws IOException {
        xml = DocumentHelper.createDocument();
        final Element root = xml.addElement("weather");
        final Element data = root.addElement("data");

        data.addElement("info")
                .addText("Current Weather Conditions for: " + weather.getCity()
                        + ", " + weather.getRegion() + ", "
                        + weather.getCountry());
        data.addElement("temperature").addText(weather.getTemp());
        data.addElement("condition").addText(weather.getCondition());
        data.addElement("humidity").addText(weather.getHumidity());
        data.addElement("chill").addText(weather.getChill());

        if (Files.notExists(
                Paths.get(path + "Weather" + weather.getCity() + ".xml"))) {
            Files.createFile(
                    Paths.get(path + "Weather" + weather.getCity() + ".xml"));
        }

        Files.write(Paths.get(path + "Weather" + weather.getCity() + ".xml"),
                xml.asXML().getBytes(Charset.forName("UTF-8")),
                StandardOpenOption.TRUNCATE_EXISTING);
    }

}
