package com.example.finalproject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSPServer {
    @POST("final_project/{URL}")
        Call<PictureBean> getPictures(@Path("URL") String URL);

    @POST("final_project/{URL}")
        Call<String> Memberidoverlap(@Path("URL") String URL, @Query("id") String id);


    @POST("final_project/{URL}")
    Call<PictureBean> getPictures2(@Path("URL") String URL ,@Query("id") String id);

    @POST("final_project/{URL}")
    Call<String> InsertMember(@Path("URL")String URL, @Body MemberBean bean);
    @POST("final_project/{URL}")
    Call<MemberBean> EazyLogin(@Path("URL") String URL ,@Query("id") long id);
    @POST("final_project/{URL}")
    Call<MemberBean> MemberLogin(@Path("URL") String URL ,@Query("id") String id,@Query("pass") String pw);
    @POST("final_project/{URL}")
    Call<String> MemberGetId(@Path("URL") String URL ,@Query("hp") String hp);
    @POST("final_project/{URL}")
    Call<String> UpdatePass(@Path("URL") String URL ,@Query("id") String id,@Query("pass") String pw);
    @POST("final_project/{URL}")
    Call<String> GetMyInfo(@Path("URL") String URL ,@Query("hp") String hp);
    @POST("final_project/{URL}")
    Call<ArrayList<MyPcBean>> MyPcGet(@Path("URL") String URL, @Query("id") String name);
<<<<<<< HEAD

    @POST("final_project/{URL}")
    Call<String> bookmarkup(@Path("URL") String URL,@Body MyPcBean bean);

    @POST("final_project/{URL}")
    Call<String> Seatsearch(@Path("URL") String URL,@Query("id") String id);

    @POST("final_project/{URL}")
    Call<String> pcjonDelete(@Path("URL") String URL,@Query("p_id") String p_id,@Query("m_id") String m_id);


=======
    @POST("final_project/{URL}")
    Call<PcRoomBean> getPcinfo(@Path("URL") String URL);
>>>>>>> 42b5c8de5cdfe92b4c0704c0e0cd70e5ca64a967
}
