package com.example.maynooth.qrscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button qrscanner_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qrscanner_btn = (Button) findViewById(R.id.qrscanner_btn);
        qrscanner_btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        if (v == qrscanner_btn)
        {
            Intent scanner = new Intent(this,  QRScannerActivity.class);
            startActivity(scanner);
        }
    }
}
