package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {

    public static class Codec {

        private final Map<String, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String hash = Integer.toHexString(longUrl.hashCode());
            map.put(hash, longUrl);
            return hash;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }

}
