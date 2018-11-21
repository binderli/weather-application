/*
 * package de.fh.albsig.binderlisa86099;
 * 
 * import java.io.InputStream;
 * 
 * import org.junit.jupiter.api.Test;
 * 
 * import de.fh.albsig.weather.Weather; import de.fh.albsig.weather.YahooParser;
 * import junit.framework.TestCase;
 * 
 * public class YahooParserTest extends TestCase {
 * 
 * public YahooParserTest(String name) throws Exception { super(name);
 * 
 * }
 * 
 * @Test public void testParser() throws Exception { final InputStream testData
 * = getClass().getClassLoader().getResourceAsStream("b-weather.xml"); final
 * Weather weather = new YahooParser().parse(testData); assertEquals("Berlin",
 * weather.getCity()); assertEquals(" BE", weather.getRegion());
 * assertEquals("Germany", weather.getCountry()); assertEquals("2",
 * weather.getTemp()); assertEquals("Mostly Cloudy", weather.getCondition());
 * assertEquals("28", weather.getChill()); assertEquals("88",
 * weather.getHumidity());
 * 
 * }
 * 
 * }
 */