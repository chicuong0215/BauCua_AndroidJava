package com.cuong.app.baucua;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cuong.app.baucua.ui.dialog.CoinSelectionDialog;
import com.cuong.app.baucua.ui.dialog.RotateDialog;
import com.cuong.app.baucua.utils.ScreenUtils;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private long coin = 1000000;
    private long reverseCoin = 0;
    private long selectionCoin = 0;
    private boolean isRotate = true;

    private final Map<String, Long> selectionArr = new HashMap<>();
    private final Map<String, Integer> resourceArr = new HashMap<>();

    //view
    private ImageButton ibtnBau, ibtnCua, ibtnTom, ibtnCa, ibtnGa, ibtnNai, ibtnCoinSelection;
    private Button btnReset, btnRotate, btnContinue;
    private TextView tvCoin, tvNai, tvBau, tvGa, tvCa, tvCua, tvTom, tvSelection, tvEarn;
    private ImageView imgvItem1, imgvItem2, imgvItem3;
    private LinearLayout llCoinSelection;

    //utils
    private Toast toast;
    private final NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    //database
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //init screen
        super.onCreate(savedInstanceState);
        ScreenUtils.setFullScreen(getWindow());
        setContentView(R.layout.activity_main);

        initView();
        initAction();
        initData();
    }

    void initView() {
        ibtnBau = findViewById(R.id.ibtnBau);
        ibtnCua = findViewById(R.id.ibtnCua);
        ibtnTom = findViewById(R.id.ibtnTom);
        ibtnCa = findViewById(R.id.ibtnCa);
        ibtnGa = findViewById(R.id.ibtnGa);
        ibtnNai = findViewById(R.id.ibtnNai);
        ibtnCoinSelection = findViewById(R.id.ibtnCoinSelection);

        btnReset = findViewById(R.id.btnReset);
        btnRotate = findViewById(R.id.btnRotate);
        btnContinue = findViewById(R.id.btnContinue);

        tvCoin = findViewById(R.id.tvCoin);
        tvNai = findViewById(R.id.tvNai);
        tvBau = findViewById(R.id.tvBau);
        tvGa = findViewById(R.id.tvGa);
        tvCa = findViewById(R.id.tvCa);
        tvCua = findViewById(R.id.tvCua);
        tvTom = findViewById(R.id.tvTom);
        tvSelection = findViewById(R.id.tvSelection);
        tvEarn = findViewById(R.id.tvEarn);

        imgvItem1 = findViewById(R.id.imgvItem1);
        imgvItem2 = findViewById(R.id.imgvItem2);
        imgvItem3 = findViewById(R.id.imgvItem3);

        llCoinSelection = findViewById(R.id.llCoinSelection);

        toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);

        initResourceArr();
        initSelectionArr();
    }

    @SuppressLint("ClickableViewAccessibility")
    void initAction() {
        //on click
        ibtnBau.setOnClickListener(this);
        ibtnCua.setOnClickListener(this);
        ibtnTom.setOnClickListener(this);
        ibtnCa.setOnClickListener(this);
        ibtnGa.setOnClickListener(this);
        ibtnNai.setOnClickListener(this);
        ibtnCoinSelection.setOnClickListener(this);

        btnReset.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnContinue.setOnClickListener(this);

        llCoinSelection.setOnClickListener(this);

        //on long click
        ibtnBau.setOnLongClickListener(this);
        ibtnCua.setOnLongClickListener(this);
        ibtnTom.setOnLongClickListener(this);
        ibtnCa.setOnLongClickListener(this);
        ibtnGa.setOnLongClickListener(this);
        ibtnNai.setOnLongClickListener(this);
    }

    void initData() {
        sharedPreferences = getSharedPreferences("bau_cua", MODE_PRIVATE);
        coin = sharedPreferences.getLong("coin", 1000000L);
        tvCoin.setText(numberFormat.format(coin));
    }

    public void updateSelection(long coin) {
        selectionCoin = coin;
        tvSelection.setText(numberFormat.format(selectionCoin));
    }

    public void updateRotate(long earnCoin) {
        this.coin += earnCoin;
        tvCoin.setText(numberFormat.format(coin));
        tvEarn.setText(numberFormat.format(earnCoin - reverseCoin));
    }

    public void resetSelectionArr() {
        initSelectionArr();

        tvNai.setText("0");
        tvBau.setText("0");
        tvGa.setText("0");
        tvCa.setText("0");
        tvCua.setText("0");
        tvTom.setText("0");

        tvCoin.setText(numberFormat.format(coin));
        tvEarn.setText(numberFormat.format(0));
    }

    public void initSelectionArr() {
        selectionArr.put("bau", 0L);
        selectionArr.put("nai", 0L);
        selectionArr.put("ga", 0L);
        selectionArr.put("tom", 0L);
        selectionArr.put("cua", 0L);
        selectionArr.put("ca", 0L);

    }

    public void initResourceArr() {
        resourceArr.put("bau", R.drawable.ic_gourd);
        resourceArr.put("nai", R.drawable.ic_deer);
        resourceArr.put("ga", R.drawable.ic_chicken);
        resourceArr.put("tom", R.drawable.ic_shrimp);
        resourceArr.put("cua", R.drawable.ic_crab);
        resourceArr.put("ca", R.drawable.ic_fish);
    }

    public void updateImageResult(String item1, String item2, String item3) {
        showImageResult();

        imgvItem1.setImageResource(resourceArr.get(item1));
        imgvItem2.setImageResource(resourceArr.get(item2));
        imgvItem3.setImageResource(resourceArr.get(item3));
    }

    public void hiddenImageResult() {
        imgvItem1.setVisibility(View.INVISIBLE);
        imgvItem2.setVisibility(View.INVISIBLE);
        imgvItem3.setVisibility(View.INVISIBLE);
    }

    public void showImageResult() {
        imgvItem1.setVisibility(View.VISIBLE);
        imgvItem2.setVisibility(View.VISIBLE);
        imgvItem3.setVisibility(View.VISIBLE);
    }

    private void updateCoinAfterSelect() {
        coin -= selectionCoin;
        reverseCoin += selectionCoin;
        tvCoin.setText(numberFormat.format(coin));
    }

    private void toast(String text) {
        toast.setText(text);
        toast.show();
    }

    public Map<String, Long> getSelectionArr() {
        return this.selectionArr;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Log.d("event", "click");
        if (selectionCoin > 0) {
            if (isRotate) {
                if (coin >= selectionCoin) {
                    switch (view.getId()) {
                        case R.id.ibtnNai:
                            selectionArr.put("nai", selectionArr.get("nai") + selectionCoin);
                            tvNai.setText(numberFormat.format(selectionArr.get("nai")));
                            updateCoinAfterSelect();
                            break;
                        case R.id.ibtnBau:
                            selectionArr.put("bau", selectionArr.get("bau") + selectionCoin);
                            tvBau.setText(numberFormat.format(selectionArr.get("bau")));
                            updateCoinAfterSelect();
                            break;
                        case R.id.ibtnGa:
                            selectionArr.put("ga", selectionArr.get("ga") + selectionCoin);
                            tvGa.setText(numberFormat.format(selectionArr.get("ga")));
                            updateCoinAfterSelect();
                            break;
                        case R.id.ibtnCa:
                            selectionArr.put("ca", selectionArr.get("ca") + selectionCoin);
                            tvCa.setText(numberFormat.format(selectionArr.get("ca")));
                            updateCoinAfterSelect();
                            break;
                        case R.id.ibtnCua:
                            selectionArr.put("cua", selectionArr.get("cua") + selectionCoin);
                            tvCua.setText(numberFormat.format(selectionArr.get("cua")));
                            updateCoinAfterSelect();
                            break;
                        case R.id.ibtnTom:
                            selectionArr.put("tom", selectionArr.get("tom") + selectionCoin);
                            tvTom.setText(numberFormat.format(selectionArr.get("tom")));
                            updateCoinAfterSelect();
                            break;
                    }
                } else {
                    toast(getResources().getString(R.string.tip_do_not_have_enough_coin));
                }
            } else {
//                toast("Nhấn đặt lại hoặc chơi tiếp!");
            }
        } else {
            new CoinSelectionDialog(this).show();
        }
        switch (view.getId()) {
            case R.id.btnRotate:
                AtomicBoolean isSelection = new AtomicBoolean(false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    selectionArr.forEach((k, v) -> {
                        if (selectionArr.get(k) > 0L) {
                            isSelection.set(true);
                        }
                    });
                }
                if (isSelection.get()) {
                    isRotate = false;

                    btnRotate.setVisibility(View.INVISIBLE);
                    btnContinue.setVisibility(View.VISIBLE);

                    new RotateDialog(this).show();
                }
                break;
            case R.id.btnReset:
                isRotate = true;

                coin += reverseCoin;
                reverseCoin = 0;

                resetSelectionArr();
                hiddenImageResult();

                btnRotate.setVisibility(View.VISIBLE);
                btnContinue.setVisibility(View.INVISIBLE);
                break;
            case R.id.btnContinue:
                coin -= reverseCoin;
                tvCoin.setText(numberFormat.format(coin));

                tvEarn.setText(numberFormat.format(0));
                hiddenImageResult();
                new RotateDialog(this).show();
                break;
            case R.id.ibtnCoinSelection:
            case R.id.llCoinSelection:
                new CoinSelectionDialog(this).show();
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences.edit().putLong("coin", coin).apply();
    }

    final CountDownTimer countDownTimer = new CountDownTimer(Long.MAX_VALUE, 30) {
        @Override
        public void onTick(long millisUntilFinished) {
            selectionArr.put("nai", selectionArr.get("nai") + selectionCoin);
            tvNai.setText(numberFormat.format(selectionArr.get("nai")));
            updateCoinAfterSelect();
        }

        @Override
        public void onFinish() {
        }
    };

    @Override
    public boolean onLongClick(View view) {
        return false;
    }
}