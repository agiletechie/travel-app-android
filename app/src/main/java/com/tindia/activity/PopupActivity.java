package com.tindia.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tindia.R;
import com.tindia.utils.AppConstants;

public class PopupActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        String stringExtra = getIntent().getStringExtra(AppConstants.POP_UP_DESC);

        TextView desc = findViewById(R.id.tv_popup_desc);
        TextView back = findViewById(R.id.tv_back);

        desc.setText(stringExtra);

        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.onBackPressed();
    }
}