package com.example.fdai3744.t_online20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        PDFView pdfview = (PDFView) findViewById(R.id.pdf_reader);
        pdfview.fromAsset("rechnung.pdf").load();
    }
}
