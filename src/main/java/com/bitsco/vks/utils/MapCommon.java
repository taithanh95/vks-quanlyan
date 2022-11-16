package com.bitsco.vks.utils;

import java.util.Map;

public class MapCommon {

    public static boolean isNullOrEmptyMap(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

}
