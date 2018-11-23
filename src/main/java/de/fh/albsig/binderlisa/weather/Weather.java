package de.fh.albsig.binderlisa.weather;

/**
 * @author Lisa Binder Matrikel-Nummer: 86099
 *
 */

public class Weather {

    private String wCity;
    private String wRegion;
    private String wCountry;
    private String wCondition;
    private String wTemperature;
    private String wChill;
    private String wHumidity;

    /**
     *
     */
    public Weather() {

    }

    /**
     * @return gibt wCity zurueck
     */
    public String getCity() {
        return wCity;
    }

    /**
     * @param city Stadt
     */
    public void setCity(String city) {
        wCity = city;
    }

    /**
     * @return gibt wRegion zurueck
     */
    public String getRegion() {
        return wRegion;
    }

    /**
     * @param region Region
     */
    public void setRegion(String region) {
        wRegion = region;
    }

    /**
     * @return gibt wCountry zurueck
     */
    public String getCountry() {
        return wCountry;
    }

    /**
     * @param country Land
     */
    public void setCountry(String country) {
        wCountry = country;
    }

    /**
     * @return gibt wCondition zurueck
     */
    public String getCondition() {
        return wCondition;
    }

    /**
     * @param condition Zustand
     */
    public void setCondition(String condition) {
        wCondition = condition;
    }

    /**
     * @return gibt temperature zurueck
     */
    public String getTemp() {
        return wTemperature;
    }

    /**
     * @param temperature Temperatur
     */
    public void setTemp(String temperature) {
        wTemperature = temperature;
    }

    /**
     * @return gibt wChill zurueck
     */
    public String getChill() {
        return wChill;
    }

    /**
     * @param chill gefuehlte Temperatur
     */
    public void setChill(String chill) {
        wChill = chill;
    }

    /**
     * @return gibt wHumidity zurueck
     */
    public String getHumidity() {
        return wHumidity;
    }

    /**
     * @param humidity Luftfeuchte
     */
    public void setHumidity(String humidity) {
        wHumidity = humidity;
    }

    /**
     * @param weather Wetter-Objekt
     * @return gibt String zurueck
     */
    public String asText(Weather weather) {
        return weather.toString();
    }

}
