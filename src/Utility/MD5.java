package Utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String eaGetMD5(String eaString) {
        try {
            MessageDigest eaMD = MessageDigest.getInstance("MD5");
 
            byte[] eaMessageDigest = eaMD.digest(eaString.getBytes());
 
            BigInteger eaNo = new BigInteger(1, eaMessageDigest);
 
            String eaHashText = eaNo.toString(16);
            while (eaHashText.length() < 32) {
                eaHashText = "0" + eaHashText;
            }
            return eaHashText;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
