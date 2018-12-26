package com.study.mvp.demo.base;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/24 16:41
 */

public class RetrofitUtils {
    private Retrofit retrofit;
    private String baseUrl="http://api.juheapi.com/japi/";
    private static RetrofitUtils retrofitUtils = new RetrofitUtils();
    private RetrofitUtils(){
    }

    public static RetrofitUtils getInstances() {
        return retrofitUtils;
    }

    public void initOKHttp(@NonNull Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)//设置连接超时
                .readTimeout(60, TimeUnit.SECONDS)//设置读取超时
                .writeTimeout(60, TimeUnit.SECONDS)//设置写入超时
                .cache(new Cache(context.getCacheDir(), 10 * 1024 * 1024))//设置缓存目录和10M缓存
                .addInterceptor(interceptor)//添加日志拦截器（该方法也可以设置公共参数，头信息）
                .build();
        retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
