package com.wyk.wisper.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * MD5 Utility
 *
 * @author elt
 */
public class Md5Utils {
    /**
     * Encrypt ordinary string with MD5 and convert it to Base64 string
     *
     * @param str the string for md5 string
     * @return md5-based base64 string
     */
    public static String stringToMd5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            final Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(md5.digest(str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
