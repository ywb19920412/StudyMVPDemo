package com.study.mvp.demo.services;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/26 9:59
 */

public class Params extends RequestBody{
    public String key;
    public String v;
    public int month;
    public int day;

    @Override
    public MediaType contentType() {
        return null;
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {

    }
}
