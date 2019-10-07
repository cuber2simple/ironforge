package org.ironforge.oauth2.utils;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class ClientUtils {

    private final static char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
            'Z'};

    public static String getClientId(String merchantId) {
        long merchantLong = Long.parseLong(merchantId);
        return toStr(merchantLong) + getAppId();
    }

    public static String getClientSecret(String clientId) {
        String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(8);
        String hmacPassword = new HmacUtils(HmacAlgorithms.HMAC_SHA_512, clientId).hmacHex(randomAlphanumeric);
        return hmacPassword;
    }

    public static String getAppId() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    private final static String _str = new String(chars);

    static int len = chars.length;

    public static String toStr(long num) {
        if (num < len) {
            return "" + chars[(int) num];
        }
        int a = (int) num % len;
        int b = (int) num / len;
        char e = chars[a];
        if (b >= len) {
            return "" + toStr(b) + e;
        } else {
            return "" + chars[b] + e;
        }
    }

    public static long toNum(String s) {
        int a = s.length() - 1;
        long val = 0;
        for (int i = a; i >= 0; i--) {
            char c = s.charAt(i);
            val += (_str.indexOf(c) * Math.pow(len, a - i));
        }
        return val;
    }
}
