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

import com.minras.android.eohpoc.thepoc.R;
import com.minras.android.eohpoc.thepoc.Storage;

public class TabFragmentUser extends Fragment {
    private Button btnLogin;
    private EditText username;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Test", "hello");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_user, container, false);
        btnLogin = (Button)view.findViewById(R.id.tabUserBtnLogin);
        username = (EditText)view.findViewById(R.id.tabUserTextLogin);
        return view;
    }

//    @Override
//    public void onStop( ){
//        super.onStop();
//        if(username.getText() != null) {
//            SharedPreferences settings = this.getActivity().getSharedPreferences(Storage.STORAGE_NAME, 0);
//            SharedPreferences.Editor editor = settings.edit();
//            editor.putString("user.name", username.getText().toString());
//            editor.apply();
//        }
//    }

    public void login() {

    }
}
