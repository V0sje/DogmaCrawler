package dogma.gui;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import org.apache.commons.validator.routines.UrlValidator;

public class CommonBal {
   
    public static Timestamp getTimestamp() {
        java.util.Date date = new java.util.Date();
        return new Timestamp(date.getTime());
    }

    public static String urlCleanup (String urlc) {
        urlc = urlc.replace("../", "");
        if (urlc.contains("?")){
                        int indexfilenameend = urlc.indexOf("?");
                        urlc = urlc.substring(0, indexfilenameend);
        }
        if (urlc.contains("#")){
                        int indexfilenameend = urlc.indexOf("#");
                        urlc = urlc.substring(0, indexfilenameend);
        }
        return urlc;
    }
    
    public static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getDomainName(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }
    
    public static boolean urlValidator(String url)
    {
        /* Getting  a UrlValidator */
        UrlValidator defaultValidator = new UrlValidator();
        return defaultValidator.isValid(url);
    }
}
