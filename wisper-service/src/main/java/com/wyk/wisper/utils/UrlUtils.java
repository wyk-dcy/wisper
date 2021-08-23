package com.wyk.wisper.utils;

import java.io.File;
import java.net.URL;

/**
 * Url Utility
 *
 * @author elt
 */
public class UrlUtils {

    /**
     * New file by url
     *
     * @param url the file url
     * @return file
     */
    public static File getFile(URL url) {
        return url == null ? null : new File(getPath(url));
    }

    /**
     * Get path of the url
     *
     * @param url the url
     * @return path of the url
     */
    public static String getPath(URL url) {
        return url == null ? null : url.getPath();
    }
}
