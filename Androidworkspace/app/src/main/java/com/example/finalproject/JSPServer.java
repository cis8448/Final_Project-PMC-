package com.example.finalproject;

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
<<<<<<< HEAD
        Call<String> Memberidoverlap(@Path("URL") String URL, @Query("id") String id);

=======
    Call<PictureBean> getPictures2(@Path("URL") String URL ,@Query("id") String id);
>>>>>>> 36cf6f71d6d1b274c07bdc1262cf96b8b61b07d3
}
