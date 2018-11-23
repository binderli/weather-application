package de.fh.albsig.exceptions;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;

/**
 * @author Lisa Binder
 *
 */
public class WeatherException extends DocumentException {
    private static Logger log = Logger.getLogger(WeatherException.class);

    /**
     * @param e Exception
     */
    public WeatherException(Exception e) {
        log.error(e.getMessage(), e);
    }
}
