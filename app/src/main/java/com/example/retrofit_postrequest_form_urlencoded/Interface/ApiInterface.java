package com.example.retrofit_postrequest_form_urlencoded.Interface;

import com.example.retrofit_postrequest_form_urlencoded.Model.Model;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("posts")
    Call<List<Model>> getAllData();

//    Using Simple @Post
//    @POST("posts")
//    Call<ResponseBody> createPost(@Body Model model);

//    Using UrlEncoded @post
//    @FormUrlEncoded
//    @POST("posts")
//    Call<Model> createPost(
//            @Field("userId") int userId,
//            @Field("title") String title,
//            @Field("body") String body
//
//    );


    //Using UrlEncoded HasMap
    @FormUrlEncoded
    @POST("posts")
    Call<Model> createPost(@FieldMap Map<String, String> fields);

}
