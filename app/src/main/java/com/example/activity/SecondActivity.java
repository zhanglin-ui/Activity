package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button_inou);
        button.setText("退出");
        EditText editText = findViewById(R.id.edit_inou);
        editText.setText(getIntent().getStringExtra("key"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                EditText editText = findViewById(R.id.edit_inou);
                System.out.println(editText.getText().toString());
                intent.putExtra("key",editText.getText().toString());
                setResult(10,intent);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
