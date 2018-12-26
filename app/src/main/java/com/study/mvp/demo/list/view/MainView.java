package com.study.mvp.demo.list.view;

import com.study.mvp.demo.base.BaseView;
import com.study.mvp.demo.list.mdole.PostQueryInfo;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/24 17:05
 */

public interface MainView extends BaseView {
    void updateListUI(PostQueryInfo postQueryInfo);
    void errorToast(String message);
}
