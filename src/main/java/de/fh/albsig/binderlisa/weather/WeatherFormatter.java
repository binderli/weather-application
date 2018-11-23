package de.fh.albsig.binderlisa.weather;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 * @author Lisa Binder Matrikel-Nummer: 86099
 *
 */

public class WeatherFormatter {

    private static Logger log = Logger.getLogger(WeatherFormatter.class);

    /**
     * @param weather Wetter-Objekt
     * @return gibt String zurueck
     * @throws Exception falls Exceptions auftreten
     */
    private ClassLoader loader = WeatherFormatter.class.getClassLoader();

    /**
     * @param weather Wetter-Objekt
     * @return gibt String zurueck
     * @throws UnsupportedEncodingException UnsupportedEncodingException
     * @throws IOException                  IOException
     */
    public final String format(final Weather weather)
            throws UnsupportedEncodingException, IOException {
        log.info("Formatting Weather Data");
        final Reader reader = new InputStreamReader(
                loader.getResourceAsStream("output.vm"));
        final VelocityContext context = new VelocityContext();
        context.put("weather", weather);
        final StringWriter writer = new StringWriter();
        Velocity.evaluate(context, writer, "", reader);
        log.info(writer.toString());
        return writer.toString();

    }
}
