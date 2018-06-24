package com.android.nfc.purchasersmartpay;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.nfc.purchasersmartpay.R;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);

    }
    public void login(View view){
        EditText username = (EditText) findViewById(R.id.login_username);
        EditText password = (EditText) findViewById(R.id.login_password);

            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);

    }
}
