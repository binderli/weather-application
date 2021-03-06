package de.fh.albsig.binderlisa.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fh.albsig.binderlisa.weather.WeatherService;

/**
 * @author Lisa Binder
 *
 */
public class WeatherServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(WeatherServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        WeatherService weatherService = new WeatherService();
        PrintWriter out = response.getWriter();
        try {
            out.println(weatherService.retrieveForecast(city, country));
        } catch (Exception e) {
            out.println("Error Retrieving Forecast: " + e.getMessage());
            log.error(e.getMessage(), e);
        }
        out.flush();
        out.close();
    }
}
