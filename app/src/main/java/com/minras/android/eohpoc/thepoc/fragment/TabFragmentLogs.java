package com.minras.android.eohpoc.thepoc.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minras.android.eohpoc.thepoc.MainActivity;
import com.minras.android.eohpoc.thepoc.R;

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
        logsTextView.setText(a.log.get());
    }
}
