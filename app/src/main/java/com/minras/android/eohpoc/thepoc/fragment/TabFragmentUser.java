package com.minras.android.eohpoc.thepoc.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.minras.android.eohpoc.thepoc.R;

public class TabFragmentUser extends Fragment {
    private Button btnLogin;
    private EditText username;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_user, container, false);
        btnLogin = (Button)view.findViewById(R.id.tabUserBtnLogin);
        username = (EditText)view.findViewById(R.id.tabUserTextLogin);
        return view;
    }

    public void login() {

    }
}
