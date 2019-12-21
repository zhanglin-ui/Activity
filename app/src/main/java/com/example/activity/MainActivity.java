package com.example.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button_inou);
        button.setText("启动");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.edit_inou);
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("key",editText.getText().toString());
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("first");
        System.out.println(requestCode);
        System.out.println(resultCode);
        if(requestCode==2){
            if(resultCode==10){
                EditText editText = findViewById(R.id.edit_inou);
                editText.setText(data.getStringExtra("key"));
            }
        }
    }
}
