package com.example.fdai3744.t_online20;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BillActivity extends Fragment {

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_bill, container, false);

        Button state001 = (Button) v.findViewById(R.id.state001);
        Button state002 = (Button) v.findViewById(R.id.state002);
        Button state003 = (Button) v.findViewById(R.id.state003);
        Button state004 = (Button) v.findViewById(R.id.state004);
        Button state005 = (Button) v.findViewById(R.id.state005);

        state001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PDFActivity.class);
                startActivity(intent);
            }
        });

        state002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PDFActivity.class);
                startActivity(intent);
            }
        });

        state003.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PDFActivity.class);
                startActivity(intent);
            }
        });

        state004.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PDFActivity.class);
                startActivity(intent);
            }
        });

        state005.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PDFActivity.class);
                startActivity(intent);
            }
        });

        return v;

    }

}
