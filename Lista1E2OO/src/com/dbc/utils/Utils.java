package com.dbc.utils;

import java.text.DecimalFormat;
import java.util.Random;

public class Utils {
    final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");
    final static Random random = new Random();

    public static Integer sortearNumero(Integer range) {
        return random.nextInt(range);
    }

    public static String formatarDouble(double valor){
        return "R$" + DECIMAL_FORMAT.format(valor);
    }
}
