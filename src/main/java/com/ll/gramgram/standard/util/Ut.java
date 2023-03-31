package com.ll.gramgram.standard.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Ut {
    public static class url {
        public static String encode(String s) {
            return URLEncoder.encode(s, StandardCharsets.UTF_8);
        }
    }
}
