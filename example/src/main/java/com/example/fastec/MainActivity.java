package com.example.fastec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.aisingioro_core.app.Aisingioro;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(Aisingioro.getApplication(), "传入Context", Toast.LENGTH_LONG).show();
    }
}