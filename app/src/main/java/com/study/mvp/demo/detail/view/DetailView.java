package com.study.mvp.demo.detail.view;

import com.study.mvp.demo.base.BaseView;
import com.study.mvp.demo.detail.modle.PostDetailInfo;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/25 16:58
 */

public interface DetailView extends BaseView {
    void updateListUI(PostDetailInfo postDetailInfo);
    void errorToast(String message);
}
