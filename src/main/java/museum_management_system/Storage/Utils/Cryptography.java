package museum_management_system.Storage.Utils;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class Cryptography {

    public static String toHash(String password) throws NoSuchAlgorithmException {
        String hashedPassword = null;
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-512");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            hashedPassword = "";
            for (int i = 0; i < hash.length; i++) {
                hashedPassword += Integer.toHexString(hash[i] & 0xFF | 0x100).substring(1,3);
            }
        } catch (java.security.NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
        return hashedPassword;
    }
}
