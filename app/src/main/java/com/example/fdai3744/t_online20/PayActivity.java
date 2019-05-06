package com.example.fdai3744.t_online20;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;

public class PayActivity extends Fragment {

    private static final int CAMERA_REQUEST = 1;
    private static final String NUMBER = "0123456789101112";
    private static boolean used = false;

    View v;
    View v2;
    ImageView qrbutton;
    EditText editText;
    Button button;
    //TextView amount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_pay, container, false);

        qrbutton = (ImageView) v.findViewById(R.id.qrbutton);
        editText = (EditText) v.findViewById(R.id.editInvoiceNumber_bill);
        button = (Button) v.findViewById(R.id.topupbutton);
        //amount = (TextView) v.findViewById(R.id.topup);

        final SecondActivity secondActivity = (SecondActivity) getActivity();


        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if (String.valueOf(editText.getText()).equals(NUMBER) && !used) {
                    used = true;
                    Toast.makeText(getActivity(), "Es werden Ihnen 15 Euro gutgeschrieben.", Toast.LENGTH_LONG).show();
                    double topup = secondActivity.getAmountValue();
                    secondActivity.changeAmountValue(new DecimalFormat("##.##").format(topup + 15));
                }
                else if (String.valueOf(editText.getText()).equals(NUMBER) && used) {
                    Toast.makeText(getActivity(), "Sie haben schon mit dieser Nummer aufgeladen!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getActivity(), "Die eingegebene Nummer ist ungültig", Toast.LENGTH_LONG).show();
                }
            }
        });

        qrbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST);
            }
        });

        return v;
    }
}
