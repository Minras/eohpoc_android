package com.minras.android.eohpoc.thepoc.fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.minras.android.eohpoc.thepoc.Config;
import com.minras.android.eohpoc.thepoc.R;

public class TabFragmentUser extends Fragment
        implements View.OnClickListener {
    private View view;
    private EditText username;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Test", "hello");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment_user, container, false);

        username = (EditText)view.findViewById(R.id.tabUserTextLogin);
        Button btnLogin = (Button)view.findViewById(R.id.tabUserBtnLogin);
        btnLogin.setOnClickListener(this);

        return view;
    }

    @Override
    public void onStop(){
        super.onStop();
        if(username.getText() != null) {
            SharedPreferences settings = this.getActivity().getSharedPreferences(Config.STORAGE_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("user.name", username.getText().toString());
            editor.apply();
        }
    }

    public void login() {
        Log.i(Config.APP_LOG_TAG, String.format(
                "Logging in with the new user: %s", username.getText().toString()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tabUserBtnLogin:
                login();
                break;
        }
    }
}
