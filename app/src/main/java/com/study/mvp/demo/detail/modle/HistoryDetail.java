package com.study.mvp.demo.detail.modle;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/25 15:52
 */

public class HistoryDetail {
    public String content;
    public int day;
    public String des;
    public String _id;
    public String lunar;
    public int month;
    public String pic;
    public String title;
    public int year;

    @Override
    public String toString() {
        return "content：" + content + '\n' +
                "day：" + day +'\n'+
                "des：" + des + '\n' +
                "_id：" + _id + '\n' +
                "lunar：" + lunar + '\n' +
                "month：" + month +'\n'+
                "pic：" + pic + '\n' +
                "title：" + title + '\n' +
                "year：" + year;
    }
}
