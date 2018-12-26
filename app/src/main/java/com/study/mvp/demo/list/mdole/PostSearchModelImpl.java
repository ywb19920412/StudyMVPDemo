package com.study.mvp.demo.list.mdole;

import com.study.mvp.demo.base.RetrofitUtils;
import com.study.mvp.demo.services.Params;
import com.study.mvp.demo.services.PostServiceBiz;

import okhttp3.FormBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/24 16:56
 */

public class PostSearchModelImpl implements PostSearchModel {
    @Override
    public void requestPostSearch(FormBody params, final PostSearchCallback callback) {
        RetrofitUtils.getInstances()
                .getRetrofit()
                .create(PostServiceBiz.class)
                .searchRx(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PostQueryInfo>() {
                    @Override
                    public void onCompleted() {
                        //请求结束回调
                    }

                    @Override
                    public void onError(Throwable e) {
                        //错误回调
                        callback.requestPostSearchFail(e.getMessage());
                    }

                    @Override
                    public void onNext(PostQueryInfo postQueryInfo) {
                        //成功结果返回
                        callback.requestPostSearchSuccess(postQueryInfo);
                    }
                });
//        Retrofit retrofit = RetrofitUtils.getInstances().getRetrofit();
//        PostServiceBiz postServiceBiz = retrofit.create(PostServiceBiz.class);
//        Call<PostQueryInfo> call = postServiceBiz.searchRx(key, v, month, day);
//        call.enqueue(new Callback<PostQueryInfo>() {
//            @Override
//            public void onResponse(Call<PostQueryInfo> call, Response<PostQueryInfo> response) {
//                callback.requestPostSearchSuccess(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<PostQueryInfo> call, Throwable t) {
//                callback.requestPostSearchFail(t.toString());
//            }
//        });
    }
}
