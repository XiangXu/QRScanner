package com.example.maynooth.qrscanner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{


    private EditText usernameText;
    private EditText passwordText;
    private Button loginBtn;

    //Hard code username and password
    private static final String LOGIN_USERNAME = "admin";
    private static final String LOGIN_PASSWORD = "pass";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameText = (EditText) findViewById(R.id.username_text);
        passwordText = (EditText) findViewById(R.id.password_text);

        loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == loginBtn)
        {
            if(usernameText.getText().toString().trim().equals(""))
            {
                usernameText.requestFocus();
                usernameText.setError("Please input your username");
                return;
            }
            else if(passwordText.getText().toString().trim().equals(""))
            {
                passwordText.requestFocus();
                passwordText.setError("Please input your password");
                return;
            }
            else
            {
                String username = usernameText.getText().toString().trim();
                String password = passwordText.getText().toString().trim();

                if(username.equals(LOGIN_USERNAME) && password.equals(LOGIN_PASSWORD))
                {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, " Invalid log in credentials  ", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE)
                && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit."))
        {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
