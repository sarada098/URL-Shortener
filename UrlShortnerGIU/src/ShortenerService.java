import java.util.HashMap;
import java.util.Map;

/**
 * Link Shortener Application
 * Author: Sarada pradhan
 * Date: 04/01/2024
 */


public class ShortenerService {
    private Map<String, String> shortToLongMap;
    private Map<String, String> longToShortMap;

    public ShortenerService() {
        shortToLongMap = new HashMap<>();
        longToShortMap = new HashMap<>();
    }

    public String shortenURL(String longURL) {
        String shortURL = HashGenerator.generateHash(longURL).substring(0, 8);
        
        if (shortToLongMap.containsKey(shortURL)) {
            // Handle collision (extremely rare in this simplified example)
            return shortenURL(longURL + System.currentTimeMillis());
        }

        shortToLongMap.put(shortURL, longURL);
        longToShortMap.put(longURL, shortURL);

        return shortURL;
    }

    public String expandURL(String shortURL) {
        return shortToLongMap.get(shortURL);
    }

    // Other methods for error handling, persistence, etc.
}
