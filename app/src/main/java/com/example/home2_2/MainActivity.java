package com.example.home2_2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button button;
    private TextView tvEnter;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        button = findViewById(R.id.login_btn);
        tvEnter = findViewById(R.id.vhod);
        textView2 = findViewById(R.id.zareg);
        textView3 = findViewById(R.id.zabl);
        textView4 = findViewById(R.id.click);


        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etEmail.getText().toString().isEmpty()) {
                    button.setBackgroundColor(Color.GRAY);
                } else {
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etEmail.getText().toString().equals("admin") &&
                        etPassword.getText().toString().equals("admin")) {
                    etEmail.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    etPassword.setVisibility(View.GONE);
                    tvEnter.setVisibility(View.GONE);
                    textView4.setVisibility(View.GONE);
                    textView2.setVisibility(View.GONE);
                    textView3.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this,
                            "Вы успешно зарегистрировались",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Не правильный логин или пароль",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}