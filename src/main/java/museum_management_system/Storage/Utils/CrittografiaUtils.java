package museum_management_system.Storage.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CrittografiaUtils {

    public static String getMD5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : messageDigest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
