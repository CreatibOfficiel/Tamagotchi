package com.example.tamagotchi.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;

public class Utils {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

}
