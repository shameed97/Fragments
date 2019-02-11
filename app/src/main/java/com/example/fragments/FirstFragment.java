package com.example.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    Button button;
    EditText editText;
    OnMessageReadListener messageReadListener;

    public interface OnMessageReadListener {
        void messageRead(String message);
    }

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        button = view.findViewById(R.id.btn_1);
        editText = view.findViewById(R.id.get_edit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                messageReadListener.messageRead(message);

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            messageReadListener = (OnMessageReadListener) activity;
        } catch (Exception e) {
            Log.d("sha", "e");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        editText.setText("");
    }
}
