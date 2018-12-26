package com.study.mvp.demo.detail.modle;

import com.study.mvp.demo.base.RetrofitUtils;
import com.study.mvp.demo.services.PostServiceBiz;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/24 16:56
 */

public class PostDetailModelImpl implements PostDetailModel {

    @Override
    public void requestPostDetail(String key, String v, String id,final PostSearchCallback callback) {
        RetrofitUtils.getInstances()
                .getRetrofit()
                .create(PostServiceBiz.class)
                .detail(key, v, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PostDetailInfo>() {
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
                    public void onNext(PostDetailInfo postDetailInfo) {
                        callback.requestPostSearchSuccess(postDetailInfo);
                    }
                });
    }
}
