package com.example.android.numerykont;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view) {
        String [] address={input(),input()};
        String subject = "Nr konta bankowego";
        String text = "Dane mojego konta bankowego: \nNEST BANK \n09 1870 1045 2078 1007 7542 0001 \n \nMarta Cieciura";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/html");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, address);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void sendSMS(View v) {
        Uri uri = Uri.parse("smsto:"+input());
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "NEST BANK: 09 1870 1045 2078 1007 7542 0001");
        if (it.resolveActivity(getPackageManager()) != null) {
            startActivity(it);
        }
    }

    public String input() {
        EditText editText = (EditText) findViewById(R.id.input);
        String strValue = editText.getText().toString();
        return strValue;
    }
}
