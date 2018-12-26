package com.study.mvp.demo.list.mdole;

import com.study.mvp.demo.services.Params;

import okhttp3.FormBody;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/24 16:53
 */

public interface PostSearchModel {
    void requestPostSearch(FormBody params, PostSearchCallback callback);

    interface PostSearchCallback{
        void requestPostSearchSuccess(PostQueryInfo postQueryInfo);
        void requestPostSearchFail(String failStr);
    }
}
