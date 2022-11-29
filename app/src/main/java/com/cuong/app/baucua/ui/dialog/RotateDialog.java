package com.cuong.app.baucua.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;

import com.cuong.app.baucua.MainActivity;
import com.cuong.app.baucua.R;
import com.cuong.app.baucua.data.db.model.BauCua;

public class RotateDialog extends Dialog {
    private MainActivity mainActivity;
    private BauCua bauCua;

    public RotateDialog(@NonNull Context context) {
        super(context);

        this.mainActivity = (MainActivity) context;
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.setContentView(R.layout.dialog_rotate);

        bauCua = new BauCua();

        String item1 = bauCua.random();
        String item2 = bauCua.random();
        String item3 = bauCua.random();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mainActivity.selectionArr.forEach((k, v) -> {
                if (k.equals(item1)) {
                    mainActivity.coin += 2L * mainActivity.selectionArr.get(k);
                    mainActivity.earn += 2L * mainActivity.selectionArr.get(k);
                    mainActivity.setImageResult(1, item1);
                }
                if (k.equals(item2)) {
                    mainActivity.coin += 2L * mainActivity.selectionArr.get(k);
                    mainActivity.setImageResult(2, item2);
                    mainActivity.earn += 2L * mainActivity.selectionArr.get(k);
                }
                if (k.equals(item3)) {
                    mainActivity.coin += 2L * mainActivity.selectionArr.get(k);
                    mainActivity.setImageResult(3, item3);
                    mainActivity.earn += 2L * mainActivity.selectionArr.get(k);
                }
            });
        }

        mainActivity.earn -= mainActivity.reverse;

        mainActivity.loadScore();
        mainActivity.resetSelection();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, 500);
    }
}
