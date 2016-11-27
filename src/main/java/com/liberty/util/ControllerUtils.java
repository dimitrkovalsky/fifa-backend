package com.liberty.util;

import static com.google.common.base.Strings.isNullOrEmpty;

public class ControllerUtils {

    private static final String SPLITTER = ",";

    public static String[] splitRequestParameter(String requestParameter) {
        if (isNullOrEmpty(requestParameter)) {
            return null;
        }
        return requestParameter.split(SPLITTER);
    }
}
