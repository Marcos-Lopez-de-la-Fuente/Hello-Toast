package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonToast;
    private Button buttonCount;
    private TextView showCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.buttonToast = findViewById(R.id.button_toast);
        this.buttonCount = findViewById(R.id.button_count);
        this.showCount = findViewById(R.id.show_count);


        if (savedInstanceState != null) {
            this.showCount.setText(savedInstanceState.getString("numberCount"));
        }


        this.buttonCount.setOnClickListener(view ->
                this.sumCount()
        );

        this.buttonToast.setOnClickListener(view ->
                this.showToastCount()
        );
    }

    public void sumCount() {
        int sum = Integer.parseInt((String) this.showCount.getText()) + 1;
        this.showCount.setText(String.valueOf(sum));

    }


    public void showToastCount() {
        Toast.makeText(this, showCount.getText(), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("numberCount", (String) this.showCount.getText());

    }
}