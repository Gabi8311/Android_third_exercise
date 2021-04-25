package com.example.foobarscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout cL;
    private TextView tV_password;
    private EditText eT_email;
    private EditText eT_password;
    private TextView tV_error;
    private Button btn_enter;
    private TextView tV_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cL = findViewById(R.id.cL);
        tV_password = findViewById(R.id.tV_password);
        eT_email = findViewById(R.id.eT_email);
        eT_password = findViewById(R.id.eTp_password);
        tV_error = findViewById(R.id.tV_error);
        btn_enter = findViewById(R.id.btn_enter);
        tV_sign_up = findViewById(R.id.tV_sign_up);

        tV_sign_up.setText(Html.fromHtml(getResources().getString(R.string.sign_up)));

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                if (!eT_email.getText().toString().equalsIgnoreCase("gabidam1920@gmail.com")) {
                    eT_email.setText(R.string.incorrect_email);
                    eT_email.setTextColor(Color.parseColor(getString(R.color.red)));
                } else {
                    if (!eT_password.getText().toString().equals("Gabriel")) {
                        tV_error.setText(R.string.incorrect_password);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Toast toast2 = Toast.makeText(getApplicationContext(), getText(R.string.incorrect_password), Toast.LENGTH_SHORT);
                        toast2.show();

                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), getText(R.string.incorrect_email), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });

        //Vacia el campo del User editText
        field_email_empty(eT_email);

        //Vacia el campo del password editText
        field_password_empty(eT_password, tV_password,tV_error);
//        tV_error.setText("");
//        tV_password.setText(getText(R.string.password));

        //Limpia el foco cuando haces click en el constraint Layout
        cL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT_email.clearFocus();
                eT_password.clearFocus();
            }
        });
    }


    public void field_email_empty(EditText field) {
        field.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    field.getText().clear();
                    field.setTextColor(Color.parseColor(getString(R.color.white)));
                } else {
                    if (field.getText().toString().equalsIgnoreCase("")) {
                        field.setText(R.string.email);
                    }
                }
            }
        });
    }

    public void field_password_empty(EditText field, TextView et_pass, TextView error) {
        field.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    field.getText().clear();
                    field.setTextColor(Color.parseColor(getString(R.color.white)));
                    et_pass.setText("");
                    error.setText("");
                } else {
                    if (field.getText().toString().equalsIgnoreCase("")) {
                        et_pass.setText(R.string.password);
                    }
                }
            }
        });
    }
}
