package de.fh.albsig.binderlisa.web;
import de.fh.albsig.binderlisa.weather.WeatherService;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WeatherServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		WeatherService weatherService = new WeatherService();
		PrintWriter out = response.getWriter();
		try {
			out.println(weatherService.retrieveForecast(city, country));
		} catch (Exception e) {
			out.println("Error Retrieving Forecast: " + e.getMessage());
		}
		out.flush();
		out.close();
	}
}