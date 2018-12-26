package com.study.mvp.demo.services;

import com.study.mvp.demo.detail.modle.PostDetailInfo;
import com.study.mvp.demo.list.mdole.PostQueryInfo;

import java.util.Map;

import okhttp3.FormBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface PostServiceBiz {

    //聚合数据：查询历史上的今天的数据列表
    //http://api.juheapi.com/japi/toh?key=192ecde46865c685895cfc9ceb01d5ec&v=1.0&month=12&day=6

    //get请求方式
//    @GET("toh")
//    Observable<PostQueryInfo> searchRx(@Query("key") String key, @Query("v") String v, @Query("month") int month, @Query("day") int day);

    /**
     * post请求方式1
     * @FormUrlEncoded不能用于Get请求
     * @FormUrlEncoded将会自动将请求参数的类型调整为application/x-www-form-urlencoded，
     * 假如content传递的参数为Good Luck，那么最后得到的请求体就是content=Good+Luck
     *
     * @Field注解将每一个请求参数都存放至请求体中，还可以添加encoded参数，该参数为boolean型，
     * 具体的用法为
     * @Field(value = "book", encoded = true) String book
     * encoded参数为true的话，key-value-pair将会被编码，即将中文和特殊字符进行编码转换
     * @param key
     * @param v
     * @param month
     * @param day
     * @return
     */
    @FormUrlEncoded
    @POST("toh")
    Observable<PostQueryInfo> searchRx(@Field("key") String key, @Field("v") String v, @Field("month") int month, @Field("day") int day);

    /**
     * post请求方式2
     * FormUrlEncoded不能用于Get请求
     * 假如说有更多的请求参数，那么通过一个一个的参数传递就显得很麻烦而且容易出错，这个时候就可以用FieldMap
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST("toh")
    Observable<PostQueryInfo> searchRx(@FieldMap Map<String,Object> fields);

    /**
     * post请求方式3
     * FormUrlEncoded不能用于Get请求
     * 将请求参数封装为一个FormBody对象
     * @param body
     * @return
     */
    @POST("toh")
    Observable<PostQueryInfo> searchRx(@Body FormBody body);

    //聚合数据：根据id查询事件详情
    //http://api.juheapi.com/japi/tohdet?key=192ecde46865c685895cfc9ceb01d5ec&v=1.0&id=4847
    @GET("tohdet")
    Observable<PostDetailInfo> detail(@Query("key") String key, @Query("v") String v, @Query("id") String id);
}
