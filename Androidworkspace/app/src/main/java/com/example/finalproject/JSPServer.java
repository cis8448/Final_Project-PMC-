package com.example.finalproject;

import com.example.finalproject.Bean.ProductBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSPServer {
    @POST("final_project/{URL}")
        Call<PictureBean> getPictures(@Path("URL") String URL);

    @POST("final_project/{URL}")
        Call<ProductBean> getProductPictures(@Path("URL") String URL);

}
