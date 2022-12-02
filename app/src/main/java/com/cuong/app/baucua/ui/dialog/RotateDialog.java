package com.cuong.app.baucua.ui.dialog;

import android.app.Dialog;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.NonNull;

import com.cuong.app.baucua.MainActivity;
import com.cuong.app.baucua.R;
import com.cuong.app.baucua.data.db.model.BauCua;

public class RotateDialog extends Dialog {
    private long earn;

    public RotateDialog(@NonNull MainActivity mainActivity) {
        super(mainActivity);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.setContentView(R.layout.dialog_rotate);

        BauCua bauCua = new BauCua();
        String item1 = bauCua.random();
        String item2 = bauCua.random();
        String item3 = bauCua.random();

        mainActivity.setImageResult(item1, item2, item3);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mainActivity.selectionArr.forEach((k, v) -> {
                long selection = 2 * mainActivity.selectionArr.get(k);
                if (k.equals(item1)) {
                    earn += selection;
                }
                if (k.equals(item2)) {
                    earn += selection;
                }
                if (k.equals(item3)) {
                    earn += selection;
                }
            });
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mainActivity.updateRotate(earn);
                dismiss();
            }
        }, 500);
    }
}
