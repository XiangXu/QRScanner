package com.example.maynooth.qrscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ScannerResultActivity extends AppCompatActivity implements View.OnClickListener
{
    private static final String CORRECT = "true";

    private ImageView imageView;
    private Button homeBtn;
    private String scannerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_result);

        imageView = (ImageView) findViewById(R.id.imageView);

        homeBtn = (Button) findViewById(R.id.home_btn);
        homeBtn.setOnClickListener(this);
        scannerResult = getIntent().getStringExtra("scannerResult");

        if(CORRECT.equalsIgnoreCase(scannerResult))
            imageView.setImageResource(R.drawable.correct);
        else
            imageView.setImageResource(R.drawable.wrong);
    }

    @Override
    public void onClick(View v)
    {
        if (v == homeBtn)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
