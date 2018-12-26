package com.study.mvp.demo.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.study.mvp.demo.R;
import com.study.mvp.demo.base.StaticValue;
import com.study.mvp.demo.detail.DetailActivity;
import com.study.mvp.demo.list.mdole.HistoryData;
import com.study.mvp.demo.list.mdole.PostQueryInfo;
import com.study.mvp.demo.list.present.PostPresenter;
import com.study.mvp.demo.base.BaseActivity;
import com.study.mvp.demo.list.view.MainView;
import com.study.mvp.demo.services.Params;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.edit_month)
    EditText edit_month;
    @BindView(R.id.edit_day)
    EditText edit_day;
    @BindView(R.id.tv_query)
    TextView tv_query;
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(manager);
        PostPresenter presenter = new PostPresenter(this);
//        Map<String, Object> fields = new HashMap<>();
//        fields.put("key",StaticValue.app_key);
//        fields.put("v",StaticValue.version);
//        fields.put("month",Calendar.getInstance().get(Calendar.MONTH)+1);
//        fields.put("day",Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
//        presenter.requestHomeData(fields);

        FormBody body = new FormBody.Builder()
                .add("key", StaticValue.app_key)
                .add("v", StaticValue.version)
                .add("month", String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1))
                .add("day", String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)))
                .build();
        presenter.requestHomeData(body);
//        presenter.requestHomeData(StaticValue.app_key,StaticValue.version, Calendar.getInstance().get(Calendar.MONTH)+1,Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void updateListUI(PostQueryInfo postQueryInfo) {
       final List<HistoryData> data = postQueryInfo.result;
        System.out.println(data);
        MyAdapter adapter = new MyAdapter(this,data);
        recycler_view.setAdapter(adapter);
        adapter.setItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("id", data.get(position)._id);
                startActivity(intent);
            }
        });
    }

    @Override
    public void errorToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.tv_query)
    public void queryClick(View view) {
        String month=edit_month.getText().toString().trim();
        String day=edit_day.getText().toString().trim();
        PostPresenter presenter = new PostPresenter(this);
        if (!TextUtils.isEmpty(month) && !TextUtils.isEmpty(day)) {
            FormBody body = new FormBody.Builder()
                    .add("key", StaticValue.app_key)
                    .add("v", StaticValue.version)
                    .add("month", month)
                    .add("day", day)
                    .build();
            presenter.requestHomeData(body);
//            presenter.requestHomeData(StaticValue.app_key  , StaticValue.version, Integer.parseInt(month), Integer.parseInt(day));
        } else {
            Toast.makeText(this, "请输入要查询的时间！", Toast.LENGTH_SHORT).show();
        } 
    }
}
