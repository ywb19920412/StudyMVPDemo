package com.study.mvp.demo.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.study.mvp.demo.R;
import com.study.mvp.demo.base.StaticValue;
import com.study.mvp.demo.detail.modle.PostDetailInfo;
import com.study.mvp.demo.detail.modle.PostDetailModelImpl;
import com.study.mvp.demo.detail.present.PostDetailPresenter;
import com.study.mvp.demo.base.BaseActivity;
import com.study.mvp.demo.detail.view.DetailView;
import com.study.mvp.demo.services.Params;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/25 16:23
 */

public class DetailActivity extends BaseActivity implements DetailView{
    @BindView(R.id.text)
    TextView text;
    private String id = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("id");
        PostDetailPresenter postDetailPresenter = new PostDetailPresenter(this);
        postDetailPresenter.requestHomeData(StaticValue.app_key,StaticValue.version,id);
    }

    @Override
    public void updateListUI(PostDetailInfo postDetailInfo) {
        text.setText(postDetailInfo.result.get(0).content);
    }

    @Override
    public void errorToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
