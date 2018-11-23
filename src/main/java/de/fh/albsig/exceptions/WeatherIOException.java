package de.fh.albsig.exceptions;

import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * @author Lisa Binder
 *
 */
public class WeatherIOException extends IOException {
    private static Logger log = Logger.getLogger(WeatherIOException.class);

    /**
     * @param e Exception
     */
    public WeatherIOException(Exception e) {
        log.error(e.getMessage(), e);
    }

}
