package com.minras.android.eohpoc.thepoc.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minras.android.eohpoc.thepoc.R;

public class TabFragmentLogs extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_logs, container, false);
    }

//    public void log(String msg) {
//        TextView t = (TextView) this.getView().findViewById(R.id.textViewLogs);
//        t.setText(t.getText() + "\n" + msg);
//    }
}
