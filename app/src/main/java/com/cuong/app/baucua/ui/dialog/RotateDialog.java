package com.cuong.app.baucua.ui.dialog;

import android.app.Dialog;
import android.os.Build;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.cuong.app.baucua.MainActivity;
import com.cuong.app.baucua.R;
import com.cuong.app.baucua.data.db.model.BauCua;

import java.util.Map;

public class RotateDialog extends Dialog {
    private long earnCoin;
    private final Map<String, Long> selectionArr;

    public RotateDialog(@NonNull MainActivity mainActivity) {
        //init screen
        super(mainActivity);
        this.selectionArr = mainActivity.getSelectionArr();
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.setContentView(R.layout.dialog_rotate);

        //init view
        ImageView imgvPlate = findViewById(R.id.imgvPlate);

        //init animation
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.rotate);
        imgvPlate.setAnimation(animation);

        //rotate with delay
        new Handler().postDelayed(() -> {
            BauCua bauCua = new BauCua();

            String item1 = bauCua.random();
            String item2 = bauCua.random();
            String item3 = bauCua.random();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                selectionArr.forEach((k, v) -> {
                    long earn = 2 * selectionArr.get(k);
                    if (k.equals(item1)) {
                        earnCoin += earn;
                    }
                    if (k.equals(item2)) {
                        earnCoin += earn;
                    }
                    if (k.equals(item3)) {
                        earnCoin += earn;
                    }
                });
            }

            //update result
            mainActivity.updateImageResult(item1, item2, item3);
            mainActivity.updateRotate(earnCoin);
            dismiss();
        }, 500);
    }
}
