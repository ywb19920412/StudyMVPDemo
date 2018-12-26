package com.study.mvp.demo.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/24 17:05
 */

public class BaseActivity extends AppCompatActivity implements BaseView{
    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(this);
        dialog.setMessage("查询中...");
    }

    @Override
    public void showProgressDialog() {
        if (dialog != null) {
            dialog.show();
        }
    }

    @Override
    public void hideProgressDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
