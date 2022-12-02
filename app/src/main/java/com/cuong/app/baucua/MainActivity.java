package com.cuong.app.baucua;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cuong.app.baucua.ui.dialog.MoneySelectionDialog;
import com.cuong.app.baucua.ui.dialog.RotateDialog;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private long coin = 10000000;
    private long dollar = 100;
    private long reverse = 0;
    private long selection = 1000;
    private boolean isRotate = true;

    public Map<String, Long> selectionArr = new HashMap<>();

    //view
    private ImageButton ibtnBau, ibtnCua, ibtnTom, ibtnCa, ibtnGa, ibtnNai, ibtnMoneySelection;
    private Button btnBack, btnRotate, btnContinue;
    private TextView tvCoin, tvDollar, tvNai, tvBau, tvGa, tvCa, tvCua, tvTom, tvSelection, tvEarn;
    private ImageView imgvItem1, imgvItem2, imgvItem3;
    private LinearLayout llMoneySelection;

    //other
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        config();
        init();
        setAction();
        setData();
    }

    void config() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    void init() {
        ibtnBau = findViewById(R.id.ibtnBau);
        ibtnCua = findViewById(R.id.ibtnCua);
        ibtnTom = findViewById(R.id.ibtnTom);
        ibtnCa = findViewById(R.id.ibtnCa);
        ibtnGa = findViewById(R.id.ibtnGa);
        ibtnNai = findViewById(R.id.ibtnNai);
        ibtnMoneySelection = findViewById(R.id.ibtnMoneySelection);

        btnBack = findViewById(R.id.btnBack);
        btnRotate = findViewById(R.id.btnRotate);
        btnContinue = findViewById(R.id.btnContinue);

        tvCoin = findViewById(R.id.tvCoin);
        tvDollar = findViewById(R.id.tvDollar);
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

        llMoneySelection = findViewById(R.id.llMoneySelection);

        toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
    }

    void setAction() {
        ibtnBau.setOnClickListener(this);
        ibtnCua.setOnClickListener(this);
        ibtnTom.setOnClickListener(this);
        ibtnCa.setOnClickListener(this);
        ibtnGa.setOnClickListener(this);
        ibtnNai.setOnClickListener(this);
        ibtnMoneySelection.setOnClickListener(this);

        btnBack.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnContinue.setOnClickListener(this);

        llMoneySelection.setOnClickListener(this);
    }

    void setData() {
        tvCoin.setText(coin + " coins");
        tvDollar.setText(dollar + " Dollars");
        tvSelection.setText(selection + " coins");

        resetSelectionArr();
    }

    @SuppressLint("SetTextI18n")
    public void updateSelection(long value) {
        selection = value;
        tvSelection.setText(selection + " coins");
    }

    public void updateRotate(long earn) {
        this.coin += earn;
        tvCoin.setText(coin + " coins");
        tvEarn.setText((earn - reverse) + " coins");
        this.reverse = 0;

        resetSelectionArr();
    }

    public void resetSelectionArrView() {
        tvNai.setText("0");
        tvBau.setText("0");
        tvGa.setText("0");
        tvCa.setText("0");
        tvCua.setText("0");
        tvTom.setText("0");
    }

    public void resetSelectionArr() {
        selectionArr.put("bau", 0L);
        selectionArr.put("nai", 0L);
        selectionArr.put("ga", 0L);
        selectionArr.put("tom", 0L);
        selectionArr.put("cua", 0L);
        selectionArr.put("ca", 0L);
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibtnNai:
                if (isRotate) {
                    if (coin >= selection) {
                        tvNai.setText((Long.parseLong(tvNai.getText().toString()) + selection) + "");
                        updateCoin();
                    } else {
                        toast("Bạn không đủ tiền!");
                    }
                } else {
                    toast("Vui lòng nhấn chơi tiếp!");
                }
                break;
            case R.id.ibtnBau:
                if (isRotate) {
                    if (coin >= selection) {
                        tvBau.setText((Long.parseLong(tvBau.getText().toString()) + selection) + "");
                        updateCoin();
                    } else {
                        toast("Bạn không đủ tiền!");
                    }
                } else {
                    toast("Vui lòng nhấn chơi tiếp!");
                }
                break;
            case R.id.ibtnGa:
                if (isRotate) {
                    if (coin >= selection) {
                        tvGa.setText((Long.parseLong(tvGa.getText().toString()) + selection) + "");
                        updateCoin();
                    } else {
                        toast("Bạn không đủ tiền!");
                    }
                } else {
                    toast("Vui lòng nhấn chơi tiếp!");
                }
                break;
            case R.id.ibtnCa:
                if (isRotate) {
                    if (coin >= selection) {
                        tvCa.setText((Long.parseLong(tvCa.getText().toString()) + selection) + "");
                        updateCoin();
                    } else {
                        toast("Bạn không đủ tiền!");
                    }
                } else {
                    toast("Vui lòng nhấn chơi tiếp!");
                }
                break;
            case R.id.ibtnCua:
                if (isRotate) {
                    if (coin >= selection) {
                        tvCua.setText((Long.parseLong(tvCua.getText().toString()) + selection) + "");
                        updateCoin();
                    } else {
                        toast("Bạn không đủ tiền!");
                    }
                } else {
                    toast("Vui lòng nhấn chơi tiếp!");
                }
                break;
            case R.id.ibtnTom:
                if (isRotate) {
                    if (coin >= selection) {
                        tvTom.setText((Long.parseLong(tvTom.getText().toString()) + selection) + "");
                        updateCoin();
                    } else {
                        toast("Bạn không đủ tiền!");
                    }
                } else {
                    toast("Vui lòng nhấn chơi tiếp!");
                }
                break;
            case R.id.ibtnMoneySelection:
            case R.id.llMoneySelection:
                new MoneySelectionDialog(this).show();
                break;
            case R.id.btnBack:
                coin += reverse;
                reverse = 0;
                tvCoin.setText(coin + " coins");

                resetSelectionArrView();

                isRotate = true;
                btnRotate.setText("Lắc");
                btnRotate.setBackgroundResource(R.drawable.btn_circle);

                imgvItem1.setVisibility(View.INVISIBLE);
                imgvItem2.setVisibility(View.INVISIBLE);
                imgvItem3.setVisibility(View.INVISIBLE);
                break;
            case R.id.btnRotate:
                if (isRotate) {
                    imgvItem1.setVisibility(View.VISIBLE);
                    imgvItem2.setVisibility(View.VISIBLE);
                    imgvItem3.setVisibility(View.VISIBLE);

                    if (Long.parseLong(tvNai.getText().toString()) > 0) {
                        selectionArr.put("nai", Long.parseLong(tvNai.getText().toString()));
                    }
                    if (Long.parseLong(tvBau.getText().toString()) > 0) {
                        selectionArr.put("bau", Long.parseLong(tvBau.getText().toString()));
                    }
                    if (Long.parseLong(tvGa.getText().toString()) > 0) {
                        selectionArr.put("ga", Long.parseLong(tvGa.getText().toString()));
                    }
                    if (Long.parseLong(tvCa.getText().toString()) > 0) {
                        selectionArr.put("ca", Long.parseLong(tvCa.getText().toString()));
                    }
                    if (Long.parseLong(tvCua.getText().toString()) > 0) {
                        selectionArr.put("cua", Long.parseLong(tvCua.getText().toString()));
                    }
                    if (Long.parseLong(tvTom.getText().toString()) > 0) {
                        selectionArr.put("tom", Long.parseLong(tvTom.getText().toString()));
                    }

                    isRotate = false;
                    btnRotate.setText("Chơi tiếp");
                    btnRotate.setBackgroundResource(R.drawable.btn_circle_2);
                    new RotateDialog(this).show();
                } else {
                    imgvItem1.setVisibility(View.INVISIBLE);
                    imgvItem2.setVisibility(View.INVISIBLE);
                    imgvItem3.setVisibility(View.INVISIBLE);

                    resetSelectionArrView();
                    tvEarn.setText("0 coins");
                    isRotate = true;
                    btnRotate.setText("Lắc");
                    btnRotate.setBackgroundResource(R.drawable.btn_circle);
                }
                break;
            case R.id.btnContinue:
                break;
        }
    }

    public void setImageResult(String item1, String item2, String item3) {

        switch (item1) {
            case "bau":
                imgvItem1.setImageResource(R.drawable.ic_gourd);
                break;
            case "nai":
                imgvItem1.setImageResource(R.drawable.ic_deer);
                break;
            case "ga":
                imgvItem1.setImageResource(R.drawable.ic_chicken);
                break;
            case "ca":
                imgvItem1.setImageResource(R.drawable.ic_fish);
                break;
            case "cua":
                imgvItem1.setImageResource(R.drawable.ic_crab);
                break;
            case "tom":
                imgvItem1.setImageResource(R.drawable.ic_shrimp);
                break;
            default:
                break;
        }
        switch (item2) {
            case "bau":
                imgvItem2.setImageResource(R.drawable.ic_gourd);
                break;
            case "nai":
                imgvItem2.setImageResource(R.drawable.ic_deer);
                break;
            case "ga":
                imgvItem2.setImageResource(R.drawable.ic_chicken);
                break;
            case "ca":
                imgvItem2.setImageResource(R.drawable.ic_fish);
                break;
            case "cua":
                imgvItem2.setImageResource(R.drawable.ic_crab);
                break;
            case "tom":
                imgvItem2.setImageResource(R.drawable.ic_shrimp);
                break;
            default:
                break;
        }
        switch (item3) {
            case "bau":
                imgvItem3.setImageResource(R.drawable.ic_gourd);
                break;
            case "nai":
                imgvItem3.setImageResource(R.drawable.ic_deer);
                break;
            case "ga":
                imgvItem3.setImageResource(R.drawable.ic_chicken);
                break;
            case "ca":
                imgvItem3.setImageResource(R.drawable.ic_fish);
                break;
            case "cua":
                imgvItem3.setImageResource(R.drawable.ic_crab);
                break;
            case "tom":
                imgvItem3.setImageResource(R.drawable.ic_shrimp);
                break;
            default:
                break;
        }
    }

    private void updateCoin() {
        coin -= selection;
        reverse += selection;
        tvCoin.setText(coin + " coins");
    }

    private void toast(String text) {
        toast.setText(text);
        toast.show();
    }
}