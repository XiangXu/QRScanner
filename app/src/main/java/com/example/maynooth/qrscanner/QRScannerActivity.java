package com.example.maynooth.qrscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import android.os.Bundle;
import com.google.zxing.Result;


public class QRScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler
{
    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        scannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        scannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult)
    {
        String scannerText = rawResult.getText();
        Intent intent = new Intent(this, ScannerResultActivity.class);
        intent.putExtra("scannerResult", scannerText);
        startActivity(intent);
    }

}
