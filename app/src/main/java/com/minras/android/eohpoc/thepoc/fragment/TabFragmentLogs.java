package com.minras.android.eohpoc.thepoc.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minras.android.eohpoc.thepoc.Config;
import com.minras.android.eohpoc.thepoc.MainActivity;
import com.minras.android.eohpoc.thepoc.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.android.ddmlib.logcat.LogCatMessageParser;

public class TabFragmentLogs extends Fragment {
    private static final LogCatMessageParser logCatMessageParser = new LogCatMessageParser();
    private static final String pid = Integer.toString(android.os.Process.myPid());
    private static final String logBriefPatternTpl = String.format(
            "^([VDIWEAF])/%s\\(\\d+\\):\\s+(.+)",
            Config.APP_LOG_TAG);
    private static final Pattern logBriefPattern = Pattern.compile(logBriefPatternTpl);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_logs, container, false);
        updateLogs(v);
        return v;
    }

    public static void clearLog()
    {
        try
        {
            Runtime.getRuntime().exec("logcat -c");
        }
        catch (Exception e)
        {
            Log.e(Config.APP_LOG_TAG, "Error clearing logs: " + e.getMessage());
        }
    }

    private void updateLogs(View v) {
        MainActivity a = (MainActivity)getActivity();
        TextView logsTextView = (TextView)v.findViewById(R.id.textViewLogs);

        try {
            Process process = Runtime.
                    getRuntime().
                    exec(String.format("logcat -d -v brief %s:V *:S", Config.APP_LOG_TAG));

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            StringBuilder log=new StringBuilder();
            String line;
            String displayMsg;
            while ((line = bufferedReader.readLine()) != null) {
                displayMsg = parseLogLine(line);
                if (null != displayMsg) {
                    log.append(displayMsg);
                }
            }
            logsTextView.setText(log.toString());
        } catch (IOException e) {
            Log.e(Config.APP_LOG_TAG, "Error reading logs: " + e.getMessage());
        }
    }

    private String parseLogLine(String line) {
        if (!line.contains(Config.APP_LOG_TAG)) {
            // check substring before performing regex check
            return null;
        }
        Matcher matcher = logBriefPattern.matcher(line);
        if (!matcher.matches()) {
            return null;
        }

        return String.format(
                "%s: %s\n",
                com.android.ddmlib.Log.LogLevel.getByLetterString(matcher.group(1)),
                matcher.group(2));
    }
}
