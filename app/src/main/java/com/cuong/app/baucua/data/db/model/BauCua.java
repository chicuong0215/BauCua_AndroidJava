package com.cuong.app.baucua.data.db.model;

import java.util.Random;

public class BauCua {
    private final String[] arr = new String[]{"bau", "cua", "ca", "tom", "ga", "nai"};

    public BauCua() {

    }

    public String random() {
        return arr[new Random().nextInt(6)];
    }
}
