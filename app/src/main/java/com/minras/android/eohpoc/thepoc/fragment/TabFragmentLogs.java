package com.minras.android.eohpoc.thepoc.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minras.android.eohpoc.thepoc.MainActivity;
import com.minras.android.eohpoc.thepoc.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TabFragmentLogs extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_logs, container, false);
        updateLogs(v);
        return v;
    }

    private void updateLogs(View v) {
        MainActivity a = (MainActivity)getActivity();
        TextView logsTextView = (TextView)v.findViewById(R.id.textViewLogs);

        try {
            Process process = Runtime.
                    getRuntime().
                    exec(String.format("logcat -d %s:V", MainActivity.APP_LOG_TAG));
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            StringBuilder log=new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }
            logsTextView.setText(log.toString());
        } catch (IOException e) {
            Log.e(MainActivity.APP_LOG_TAG, "Error reading logs: " + e.getMessage());
        }
    }
}
