package com.study.mvp.demo.list.present;

import com.study.mvp.demo.base.BasePresenter;
import com.study.mvp.demo.list.mdole.PostQueryInfo;
import com.study.mvp.demo.list.mdole.PostSearchModel;
import com.study.mvp.demo.list.mdole.PostSearchModelImpl;
import com.study.mvp.demo.list.view.MainView;
import com.study.mvp.demo.services.Params;

import okhttp3.FormBody;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/24 17:11
 */

public class PostPresenter extends BasePresenter<MainView> {
    private PostSearchModel postSearchModel;
    public PostPresenter(MainView mainView){
        attach(mainView);
        postSearchModel = new PostSearchModelImpl();
    }
    public void requestHomeData(FormBody params) {
        if (postSearchModel == null || mView == null) {
            return;
        }
        mView.showProgressDialog();
        postSearchModel.requestPostSearch(params, new PostSearchModel.PostSearchCallback() {
            @Override
            public void requestPostSearchSuccess(PostQueryInfo postQueryInfo) {
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
