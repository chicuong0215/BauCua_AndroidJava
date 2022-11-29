package com.cuong.app.baucua;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
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
    public long coin = 10000000;
    public long dollar = 100;
    public long reverse = 0;
    public long selection = 1000;
    public long earn = 0;
    public boolean isRotate = true;

    public Map<String, Long> selectionArr = new HashMap<>();

    //view
    private ImageButton ibtnBau, ibtnCua, ibtnTom, ibtnCa, ibtnGa, ibtnNai, ibtnMoneySelection;
    private Button btnBack, btnRotate, btnContinue;
    private TextView tvCoin, tvDollar, tvNai, tvBau, tvGa, tvCa, tvCua, tvTom, tvSelection, tvEarn;
    private ImageView imgvItem1, imgvItem2, imgvItem3;
    private LinearLayout llMoneySelection;

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
        tvCoin.setText(coin + " Coins");
        tvDollar.setText(dollar + " Dollars");
        tvSelection.setText("Chọn mệnh giá: " + selection + " coins");

        selectionArr.put("bau", 0L);
        selectionArr.put("nai", 0L);
        selectionArr.put("ga", 0L);
        selectionArr.put("tom", 0L);
        selectionArr.put("cua", 0L);
        selectionArr.put("ca", 0L);
    }

    public void updateData() {
        tvSelection.setText("Chọn mệnh giá: " + selection + " coins");
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibtnNai:
                if (isRotate) {
                    if (coin >= selection) {
                        tvNai.setText((Long.parseLong(tvNai.getText().toString()) + selection) + "");
                        coin -= selection;
                        reverse += selection;
                        tvCoin.setText(coin + " Coins");
                    } else {
                        Toast.makeText(this, "Bạn không đủ tiền!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Vui lòng nhấn chơi tiếp!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ibtnBau:
                if (isRotate) {
                    if (coin >= selection) {
                        tvBau.setText((Long.parseLong(tvBau.getText().toString()) + selection) + "");
                        coin -= selection;
                        reverse += selection;
                        tvCoin.setText(coin + " Coins");
                    } else {
                        Toast.makeText(this, "Bạn không đủ tiền!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Vui lòng nhấn chơi tiếp!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ibtnGa:
                if (isRotate) {
                    if (coin >= selection) {
                        tvGa.setText((Long.parseLong(tvGa.getText().toString()) + selection) + "");
                        coin -= selection;
                        reverse += selection;
                        tvCoin.setText(coin + " Coins");
                    } else {
                        Toast.makeText(this, "Bạn không đủ tiền!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Vui lòng nhấn chơi tiếp!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ibtnCa:
                if (isRotate) {
                    if (coin >= selection) {
                        tvCa.setText((Long.parseLong(tvCa.getText().toString()) + selection) + "");
                        coin -= selection;
                        reverse += selection;
                        tvCoin.setText(coin + " Coins");
                    } else {
                        Toast.makeText(this, "Bạn không đủ tiền!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Vui lòng nhấn chơi tiếp!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ibtnCua:
                if (isRotate) {
                    if (coin >= selection) {
                        tvCua.setText((Long.parseLong(tvCua.getText().toString()) + selection) + "");
                        coin -= selection;
                        reverse += selection;
                        tvCoin.setText(coin + " Coins");
                    } else {
                        Toast.makeText(this, "Bạn không đủ tiền!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Vui lòng nhấn chơi tiếp!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ibtnTom:
                if (isRotate) {
                    if (coin >= selection) {
                        tvTom.setText((Long.parseLong(tvTom.getText().toString()) + selection) + "");
                        coin -= selection;
                        reverse += selection;
                        tvCoin.setText(coin + " Coins");
                    } else {
                        Toast.makeText(this, "Bạn không đủ tiền!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Vui lòng nhấn chơi tiếp!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ibtnMoneySelection:
                new MoneySelectionDialog(this).show();
                break;
            case R.id.btnBack:
                coin += reverse;
                reverse = 0;
                tvCoin.setText(coin + " Coins");

                tvNai.setText("0");
                tvBau.setText("0");
                tvGa.setText("0");
                tvCa.setText("0");
                tvCua.setText("0");
                tvTom.setText("0");

                isRotate = true;
                btnRotate.setText("Lắc");
                break;
            case R.id.btnRotate:
                if (isRotate) {
                    if (Long.parseLong(tvNai.getText().toString()) > 0) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            selectionArr.replace("nai", Long.parseLong(tvNai.getText().toString()));
                        }
                    }
                    if (Long.parseLong(tvBau.getText().toString()) > 0) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            selectionArr.replace("bau", Long.parseLong(tvBau.getText().toString()));
                        }
                    }
                    if (Long.parseLong(tvGa.getText().toString()) > 0) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            selectionArr.replace("ga", Long.parseLong(tvGa.getText().toString()));
                        }
                    }
                    if (Long.parseLong(tvCa.getText().toString()) > 0) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            selectionArr.replace("ca", Long.parseLong(tvCa.getText().toString()));
                        }
                    }
                    if (Long.parseLong(tvCua.getText().toString()) > 0) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            selectionArr.replace("cua", Long.parseLong(tvCua.getText().toString()));
                        }
                    }
                    if (Long.parseLong(tvTom.getText().toString()) > 0) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            selectionArr.replace("tom", Long.parseLong(tvTom.getText().toString()));
                        }
                    }
                    new RotateDialog(this).show();
                    isRotate = false;
                    btnRotate.setText("Chơi tiếp");
                    btnRotate.setBackgroundResource(R.drawable.btn_circle_2);

//                    ibtnBau.setEnabled(false);
//                    ibtnNai.setEnabled(false);
//                    ibtnGa.setEnabled(false);
//                    ibtnCua.setEnabled(false);
//                    ibtnTom.setEnabled(false);
//                    ibtnCa.setEnabled(false);
                } else {
                    refresh();
                    earn = 0L;
                    tvEarn.setText("Lợi nhuận: 0 Coins");
                    isRotate = true;
                    btnRotate.setText("Lắc");
                    btnRotate.setBackgroundResource(R.drawable.btn_circle);

//                    ibtnBau.setEnabled(true);
//                    ibtnNai.setEnabled(true);
//                    ibtnGa.setEnabled(true);
//                    ibtnCua.setEnabled(true);
//                    ibtnTom.setEnabled(true);
//                    ibtnCa.setEnabled(true);
                }


                break;
            case R.id.btnContinue:
                break;
            case R.id.llMoneySelection:
                new MoneySelectionDialog(this).show();
                break;
        }
    }

    public void loadScore() {
        reverse = 0;
        tvCoin.setText(coin + " Coins");
        tvEarn.setText("Lợi nhuận: " + earn + " Coins");
    }

    public void refresh() {
        tvNai.setText("0");
        tvBau.setText("0");
        tvGa.setText("0");
        tvCa.setText("0");
        tvCua.setText("0");
        tvTom.setText("0");
    }

    public void resetSelection() {
        selectionArr.put("bau", 0L);
        selectionArr.put("nai", 0L);
        selectionArr.put("ga", 0L);
        selectionArr.put("tom", 0L);
        selectionArr.put("cua", 0L);
        selectionArr.put("ca", 0L);
    }

    public void setImageResult(int position, String result) {
        if (position == 1) {
            switch (result) {
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
        } else if (position == 2) {
            switch (result) {
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
        } else {
            switch (result) {
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
    }
}