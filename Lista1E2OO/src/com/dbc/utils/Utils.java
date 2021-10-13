package com.dbc.utils;

import java.text.DecimalFormat;

public class Utils {
    final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");

    public static String formatarDouble(double valor){
        return "R$" + DECIMAL_FORMAT.format(valor);
    }
}
