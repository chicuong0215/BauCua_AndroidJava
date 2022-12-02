package com.cuong.app.baucua.ui.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.cuong.app.baucua.MainActivity;
import com.cuong.app.baucua.R;

public class MoneySelectionDialog extends Dialog implements View.OnClickListener {
    private final MainActivity mainActivity;

    public MoneySelectionDialog(@NonNull MainActivity mainActivity) {
        super(mainActivity);
        this.mainActivity = mainActivity;
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.setContentView(R.layout.dialog_money_selection);

        Button btn1000 = findViewById(R.id.btn1000);
        Button btn2000 = findViewById(R.id.btn2000);
        Button btn5000 = findViewById(R.id.btn5000);
        Button btn10000 = findViewById(R.id.btn10000);
        Button btn20000 = findViewById(R.id.btn20000);
        Button btn50000 = findViewById(R.id.btn50000);

        btn1000.setOnClickListener(this);
        btn2000.setOnClickListener(this);
        btn5000.setOnClickListener(this);
        btn10000.setOnClickListener(this);
        btn20000.setOnClickListener(this);
        btn50000.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1000:
                setSelection(1000);
                break;
            case R.id.btn2000:
                setSelection(2000);
                break;
            case R.id.btn5000:
                setSelection(5000);
                break;
            case R.id.btn10000:
                setSelection(10000);
                break;
            case R.id.btn20000:
                setSelection(20000);
                break;
            case R.id.btn50000:
                setSelection(50000);
                break;
        }
    }

    private void setSelection(long value) {
        mainActivity.updateSelection(value);
        this.dismiss();
    }
}
