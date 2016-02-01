package com.minras.android.eohpoc.thepoc;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by andrii.shchurkov on 27-01-2016.
 */
public class Log {
    public static final String STORAGE_KEY_LOGS = "log";

    SharedPreferences sharedPreferences;

    public Log(Activity a) {
        sharedPreferences = a.getSharedPreferences(Storage.STORAGE_NAME, 0);
        sharedPreferences.
                edit().
                putString(STORAGE_KEY_LOGS, "").
                apply();
    }

    public void add(String msg) {
        sharedPreferences.edit().
                putString(
                        STORAGE_KEY_LOGS,
                        sharedPreferences.getString(STORAGE_KEY_LOGS, "") + "\n" + msg).
                apply();
    }

    public String get() {
        return sharedPreferences.getString(STORAGE_KEY_LOGS, "");
    }
}
