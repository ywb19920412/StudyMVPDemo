package com.study.mvp.demo.detail.present;

import com.study.mvp.demo.base.BasePresenter;
import com.study.mvp.demo.detail.modle.PostDetailInfo;
import com.study.mvp.demo.detail.modle.PostDetailModel;
import com.study.mvp.demo.detail.modle.PostDetailModelImpl;
import com.study.mvp.demo.detail.view.DetailView;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/24 17:11
 */

public class PostDetailPresenter extends BasePresenter<DetailView> {
    private PostDetailModel postDetailModel;
    public PostDetailPresenter(DetailView mainView){
        attach(mainView);
        postDetailModel = new PostDetailModelImpl();
    }
    public void requestHomeData(String key,String v,String id) {
        if (postDetailModel == null || mView == null) {
            return;
        }
        mView.showProgressDialog();
        postDetailModel.requestPostDetail(key,v,id, new PostDetailModelImpl.PostSearchCallback() {
            @Override
            public void requestPostSearchSuccess(PostDetailInfo postQueryInfo) {
                mView.hideProgressDialog();
                if (postQueryInfo != null && postQueryInfo.error_code == 0) {
                    mView.updateListUI(postQueryInfo);
                } else {
                    mView.errorToast(postQueryInfo.reason);
                }
            }

            @Override
            public void requestPostSearchFail(String failStr) {
                mView.hideProgressDialog();
                mView.errorToast(failStr);
            }
        });
    }
}
