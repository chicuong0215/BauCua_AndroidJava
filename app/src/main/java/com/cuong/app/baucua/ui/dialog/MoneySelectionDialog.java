package com.cuong.app.baucua.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.cuong.app.baucua.MainActivity;
import com.cuong.app.baucua.R;

public class MoneySelectionDialog extends Dialog implements View.OnClickListener {
    private MainActivity mainActivity;

    public MoneySelectionDialog(@NonNull Context context) {
        super(context);

        this.mainActivity = (MainActivity) context;
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1000:
                mainActivity.selection = 1000;
                mainActivity.updateData();
                this.dismiss();
                break;
            case R.id.btn2000:
                mainActivity.selection = 2000;
                mainActivity.updateData();
                this.dismiss();
                break;
            case R.id.btn5000:
                mainActivity.selection = 5000;
                mainActivity.updateData();
                this.dismiss();
                break;
            case R.id.btn10000:
                mainActivity.selection = 10000;
                mainActivity.updateData();
                this.dismiss();
                break;
            case R.id.btn20000:
                mainActivity.selection = 20000;
                mainActivity.updateData();
                this.dismiss();
                break;
            case R.id.btn50000:
                mainActivity.selection = 50000;
                mainActivity.updateData();
                this.dismiss();
                break;
        }
    }
}
