package com.wyk.wisper.utils;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Static utility methods pertaining to {@code String} instances.
 *
 * @author elt
 * @since 1.0
 */
public final class StringUtils {
    private static final String SINGLE_QUOTE = "'";
    private static final String DOUBLE_QUOTE = "\"";
    private static final String EMPTY = "";

    private StringUtils() {
    }

    public static String truncate(String toTruncate, int max) {
        return toTruncate.length() > max ? toTruncate.substring(0, max) : toTruncate;
    }

    @SafeVarargs
    public static <T> String joinStringsWith(String separator, T... toBeJoined) {
        StringBuilder builder = new StringBuilder();
        boolean first = true;

        for (T each : toBeJoined) {
            if (!first) {
                builder.append(separator);
            }

            builder.append(each.toString());
            first = false;
        }

        return builder.toString();
    }

    public static String joinStringsWith(String separator, double[] toBeJoined, DecimalFormat format) {
        String[] res = new String[toBeJoined.length];

        for (int i = 0; i < res.length; ++i) {
            if (format != null) {
                res[i] = format.format(toBeJoined[i]);
            } else {
                res[i] = toBeJoined[i] + "";
            }
        }

        return joinStringsWith(separator, res);
    }

    public static String joinStringsWith(String separator, double[] toBeJoined) {
        return joinStringsWith(separator, toBeJoined, null);
    }

    public static String joinStringsWith(String separator, float[] toBeJoined) {
        String[] result = new String[toBeJoined.length];

        for (int i = 0; i < result.length; ++i) {
            result[i] = toBeJoined[i] + "";
        }

        return joinStringsWith(separator, result);
    }

    public static String joinStringsWith(String separator, long[] toBeJoined) {
        String[] result = new String[toBeJoined.length];

        for (int i = 0; i < result.length; ++i) {
            result[i] = toBeJoined[i] + "";
        }

        return joinStringsWith(separator, result);
    }

    public static String joinStringsWith(String separator, int[] toBeJoined) {
        String[] result = new String[toBeJoined.length];

        for (int i = 0; i < result.length; ++i) {
            result[i] = toBeJoined[i] + "";
        }

        return joinStringsWith(separator, result);
    }

    public static String joinStringsWith(String separator, short[] toBeJoined) {
        String[] result = new String[toBeJoined.length];

        for (int i = 0; i < result.length; ++i) {
            result[i] = toBeJoined[i] + "";
        }

        return joinStringsWith(separator, result);
    }

    public static String joinStringsWith(String separator, boolean[] toBeJoined) {
        String[] result = new String[toBeJoined.length];

        for (int i = 0; i < result.length; ++i) {
            result[i] = toBeJoined[i] + "";
        }

        return joinStringsWith(separator, result);
    }

    public static boolean isNullOrOnlyWhitespace(String title) {
        return title == null || title.trim().isEmpty();
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean equalsAny(String subject, String... toMatch) {
        return subject != null && Arrays.asList(toMatch).contains(subject);
    }

    public static boolean equalsAnyIgnoreCase(String subject, String... toMatch) {
        return subject != null && Arrays.stream(toMatch).anyMatch(subject::equalsIgnoreCase);
    }

    public static boolean startsWithAnyIgnoreCase(String subject, String... toMatch) {
        return subject != null && Arrays.stream(toMatch).anyMatch(item -> subject.toLowerCase().startsWith(item.toLowerCase()));
    }

    public static String firstCharacterToUpper(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static String safeLimitedSizeString(int maxLength, String string2Limit) {
        if (string2Limit == null) {
            return "";
        } else {
            return string2Limit.length() > maxLength ? string2Limit.substring(0, maxLength - 1) : string2Limit;
        }
    }

    public static String safeLimitedSizeStringWithDots(int maxLength, String string2Limit) {
        if (string2Limit == null) {
            return "";
        }

        String result = string2Limit;
        if (string2Limit.length() > maxLength) {
            result = string2Limit.substring(0, maxLength) + "...";
            result = keepQuotes(result, string2Limit);
        }

        return result;
    }

    private static String keepQuotes(String result, String original) {
        String appendChar = EMPTY;
        if (original.startsWith(SINGLE_QUOTE) && original.endsWith(SINGLE_QUOTE)) {
            appendChar = SINGLE_QUOTE;
        } else if (original.startsWith(DOUBLE_QUOTE) && original.endsWith(DOUBLE_QUOTE)) {
            appendChar = DOUBLE_QUOTE;
        }

        return result + appendChar;
    }

    public static String extractString(String fromText, int position2Start, String begin, String end) {
        int fromPosition = position2Start - begin.length();

        int toPosition = position2Start;
        while (0 < fromPosition && !isMatch(fromText, fromPosition, begin)) {
            --fromPosition;
        }

        while (toPosition < fromText.length() && !isMatch(fromText, toPosition, end)) {
            ++toPosition;
        }

        return fromText.substring(fromPosition == 0 ? 0 : fromPosition + begin.length(), toPosition);
    }

    private static boolean isMatch(String text, int atPosition, String subStr) {
        for (int i = 0; i < subStr.length() && atPosition + i < text.length(); ++i) {
            if (subStr.charAt(i) != text.charAt(i + atPosition)) {
                return false;
            }
        }

        return true;
    }

    public static String[] newArrayLength(int length) {
        String[] strings = new String[length];

        for (int i = 0; i < length; ++i) {
            strings[i] = "";
        }

        return strings;
    }

    public static boolean startsAndEndsWith(String suffixAndPrefix, String content) {
        return content.startsWith(suffixAndPrefix) && content.endsWith(suffixAndPrefix);
    }

    public static String trimStartAndEnd(String prefix, String suffix, String content) {
        if (content.startsWith(prefix)) {
            content = content.substring(prefix.length());
        }

        if (content.endsWith(suffix)) {
            content = content.substring(0, content.length() - suffix.length());
        }

        return content;
    }

    public static String padLeftWith(String padText, String fillInCharacter, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        while (padText.length() < length) {
            stringBuilder.append(fillInCharacter);
        }

        stringBuilder.append(padText);

        return stringBuilder.toString();
    }

    public static String padRightWith(String padText, String padCharacter, int length) {
        StringBuilder padTextBuilder = new StringBuilder(padText);
        while (padTextBuilder.length() < length) {
            padTextBuilder.append(padCharacter);
        }
        return padTextBuilder.toString();
    }

    public static String padCenterWith(String padText, String padCharacter, int length) {
        StringBuilder padTextBuilder = new StringBuilder(padText);
        while (padTextBuilder.length() < length) {
            padTextBuilder.append(padCharacter);
            if (padTextBuilder.length() < length) {
                padTextBuilder.insert(0, padCharacter);
            }
        }
        padText = padTextBuilder.toString();

        return padText;
    }

    public static int numberOfOccurrences(String pattern, String val) {
        int ret = 0;
        if (val != null) {
            for (int i = 0; i < val.length(); ++i) {
                i = val.indexOf(pattern, i);
                if (i <= -1) {
                    break;
                }
                ++ret;
            }
        }

        return ret;
    }

    public static String[] divide(String separator, String value) {
        String[] result = new String[2];
        int firstOccurrenceOfSeparator = value.indexOf(separator);
        result[0] = firstOccurrenceOfSeparator == -1 ? value : value.substring(0, firstOccurrenceOfSeparator);
        result[1] = firstOccurrenceOfSeparator == -1 ? "" : value.substring(separator.length() + firstOccurrenceOfSeparator);
        return result;
    }

    public static String[] split(String separator, String value) {
        String[] ret = new String[numberOfOccurrences(separator, value) + 1];

        for (int s = 0, e, i = 0; i < ret.length; s = e + separator.length()) {
            e = value.indexOf(separator, s);
            if (e == -1) {
                e = value.length();
            }
            ret[i] = value.substring(s, e);
            ++i;
        }

        return ret;
    }

    public static String getTextAfterLastOccurrence(String text, char separator) {
        int n = text.lastIndexOf(separator) + 1;
        String name = "";
        if (n < text.length()) {
            name = text.substring(n);
        }
        return name;
    }

    public static String getTextBeforeLastOccurrence(String text, char separator) {
        int n = text.lastIndexOf(separator);
        String ret = "";
        if (n >= 0) {
            ret = text.substring(0, n);
        }
        return ret;
    }

    public static String ensureEmptyString(String text) {
        return text == null ? "" : text;
    }

    public static boolean containsAnyIgnoreCase(String str, String... words) {
        return str != null && Arrays.stream(words)
                .anyMatch(item -> containsIgnoreCase(str.toLowerCase(), item.toLowerCase()));
    }

    private static boolean containsIgnoreCase(String haystack, String needle) {
        return haystack.toLowerCase().contains(needle.toLowerCase());
    }

    public static boolean containsWord(String string, String word) {
        return string.matches(".*?\\b" + word + "\\b.*?");
    }

    public static String trimCommentAway(String s) {
        if (s == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                break;
            }

            builder.append(c);
        }

        return builder.toString();
    }

    public static String repeat(String text, int numberOfTimes) {
        String ret;
        for (ret = ""; numberOfTimes > 0; ret = ret + text) {
            --numberOfTimes;
        }
        return ret;
    }

    public static boolean isSet(String text) {
        return !isNullOrOnlyWhitespace(text);
    }

    public static String getFirstXConstants(int max, String defaultStr) {
        String ret = defaultStr.replaceAll("[aeiou]|\\W", "");
        if (ret.length() > max) {
            ret = ret.substring(0, max);
        }

        return ret;
    }

    public static String toString(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    public static int getIndexOfNthOccurrence(int n, String pattern, String value) {
        int index = 0;
        if (value != null) {
            int current = 0;
            int i = 0;

            while (current < n && i != -1) {
                i = value.indexOf(pattern, index);
                if (i >= 0) {
                    ++current;
                    index = i + 1;
                }
            }
        }

        return index - 1;
    }

    public static String trim(Object object) {
        return object == null ? "" : object.toString().trim();
    }

    public static String removeMultipleSpacing(String string2Fix) {
        StringBuilder stringBuilder = new StringBuilder();
        string2Fix = string2Fix.replace("\t", " ");
        String[] strings = string2Fix.split(" ");

        for (int i = 0; i < strings.length; ++i) {
            String substring = strings[i];
            if (!substring.isEmpty()) {
                stringBuilder.append(substring);
                if (i != strings.length - 1) {
                    stringBuilder.append(" ");
                }
            }
        }

        return stringBuilder.toString();
    }

    public static String trimTrailing(String string) {
        return string.replaceFirst("\\s++$", "");
    }

    public static boolean equals(Object obj1, Object obj2) {
        if (obj1 == obj2) {
            return true;
        } else if (obj1 != null && obj2 != null) {
            return obj1.equals(obj2);
        } else {
            return false;
        }
    }
}
