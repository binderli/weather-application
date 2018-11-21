package de.fh.albsig.binderlisa86099;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XMLOutput {

	Document xml;

	public void writeToXML(Weather weather, String path)
			throws IOException {
		xml = DocumentHelper.createDocument();
		Element root = xml.addElement("weather");
		Element data = root.addElement("data");

		data.addElement("info")
				.addText("Current Weather Conditions for: "
						+ weather.getCity() + ", "
						+ weather.getRegion() + ", "
						+ weather.getCountry());
		data.addElement("temperatur")
				.addText(weather.getTemp() + " °C");
		data.addElement("condition")
				.addText(weather.getCondition());
		data.addElement("humidity")
				.addText(weather.getHumidity());
		data.addElement("chill")
				.addText(weather.getChill() + " °C");

		if (Files.notExists(Paths.get(path + "Weather"
				+ weather.getCity() + ".xml"))) {
			Files.createFile(Paths.get(path + "Weather"
					+ weather.getCity() + ".xml"));
		}

		Files.write(
				Paths.get(path + "Weather"
						+ weather.getCity() + ".xml"),
				xml.asXML()
						.getBytes(Charset.forName("UTF-8")),
				StandardOpenOption.TRUNCATE_EXISTING);
	}

}
