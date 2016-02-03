package com.minras.android.eohpoc.thepoc.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.minras.android.eohpoc.thepoc.Config;
import com.minras.android.eohpoc.thepoc.R;

public class TabFragmentSettings extends Fragment
        implements View.OnClickListener{
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment_settings, container, false);

        Button btnClearLogs = (Button)view.findViewById(R.id.tabSettingsBtnServerUri);
        btnClearLogs.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tabSettingsBtnServerUri:
                updateServerSettings();
                break;
        }
    }

    private void updateServerSettings() {
        TextView uriTextView = (TextView)view.findViewById(R.id.tabSettingsTextServerUri);
        Log.i(Config.APP_LOG_TAG, String.format(
                "Updating server settings with new URI: %s", uriTextView.getText().toString()));
    }
}
