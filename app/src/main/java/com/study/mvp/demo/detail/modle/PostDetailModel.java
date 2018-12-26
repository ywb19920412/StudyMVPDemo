package com.study.mvp.demo.detail.modle;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/24 16:53
 */

public interface PostDetailModel {
    void requestPostDetail(String key, String v, String id, PostSearchCallback callback);

    interface PostSearchCallback{
        void requestPostSearchSuccess(PostDetailInfo postDetailInfo);
        void requestPostSearchFail(String failStr);
    }
}
